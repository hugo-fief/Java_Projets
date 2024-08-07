package todo_list;

import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import todo_list.datamodel.TodoItem;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DialogControllerTest {

	private DialogController controller;

	@BeforeEach
	public void setUp() {
		controller = new DialogController();
		controller.shortDescriptionField = new TextField();
		controller.detailsArea = new TextArea();
		controller.deadlinePicker = new DatePicker();
	}

	@Test
	public void testProcessResults() {
		controller.shortDescriptionField.setText("Test");
		controller.detailsArea.setText("Test details");
		controller.deadlinePicker.setValue(LocalDate.now());

		TodoItem item = controller.processResults();

		assertEquals("Test", item.getShortDescription());
		assertEquals("Test details", item.getDetails());
		assertEquals(LocalDate.now(), item.getDeadline());
	}

	@Test
	public void testUpdateItem() {
		TodoItem item = new TodoItem("Old Test", "Old details", LocalDate.now().minusDays(1));

		controller.shortDescriptionField.setText("Updated Test");
		controller.detailsArea.setText("Updated details");
		controller.deadlinePicker.setValue(LocalDate.now());

		controller.updateItem(item);

		assertEquals("Updated Test", item.getShortDescription());
		assertEquals("Updated details", item.getDetails());
		assertEquals(LocalDate.now(), item.getDeadline());
	}
}
