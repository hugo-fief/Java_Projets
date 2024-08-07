package todo_list;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import todo_list.datamodel.TodoData;
import todo_list.datamodel.TodoItem;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

@ExtendWith(ApplicationExtension.class)
public class DialogControllerTest {

	private DialogController dialogController;
	@SuppressWarnings("unused")
	private TodoData mockTodoData;
	@SuppressWarnings("unused")
	private Stage stage;

	@Start
	public void start(Stage stage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("todoItem-dialog.fxml"));
		stage.setScene(new Scene(loader.load()));
		this.stage = stage;
		this.dialogController = loader.getController();
		stage.show();
	}

	@BeforeEach
	public void setUp() {
		mockTodoData = mock(TodoData.class);
	}

	@Test
	public void testProcessResults() {
		dialogController.shortDescriptionField = new TextField();
		dialogController.detailsArea = new TextArea();
		dialogController.deadlinePicker = new DatePicker();

		dialogController.shortDescriptionField.setText("New Task");
		dialogController.detailsArea.setText("Details of new task");
		dialogController.deadlinePicker.setValue(LocalDate.now().plusDays(1));

		TodoItem newItem = dialogController.processResults();

		assertEquals("New Task", newItem.getShortDescription());
		assertEquals("Details of new task", newItem.getDetails());
		assertEquals(LocalDate.now().plusDays(1), newItem.getDeadline());
	}

	@SuppressWarnings("exports")
	@Test
	public void testUpdateItem(FxRobot robot) {
		TodoItem existingItem = new TodoItem("Existing Task", "Existing details", LocalDate.now());
		robot.interact(() -> {
			dialogController.shortDescriptionField.setText(existingItem.getShortDescription());
			dialogController.detailsArea.setText(existingItem.getDetails());
			dialogController.deadlinePicker.setValue(existingItem.getDeadline());
		});

		robot.clickOn(".button").lookup("OK");

		TodoItem updatedItem = dialogController.processResults();

		assertEquals(existingItem.getShortDescription(), updatedItem.getShortDescription());
		assertEquals(existingItem.getDetails(), updatedItem.getDetails());
		assertEquals(existingItem.getDeadline(), updatedItem.getDeadline());
	}
}
