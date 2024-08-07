package todo_list;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import todo_list.datamodel.TodoData;
import todo_list.datamodel.TodoItem;

import java.time.LocalDate;

import static org.mockito.Mockito.*;

public class ControllerTest {

	private Controller controller;
	private TodoData mockTodoData;
	private ListView<TodoItem> mockListView;

	@SuppressWarnings("unchecked")
	@BeforeEach
	public void setUp() {
		controller = new Controller();
		mockTodoData = Mockito.mock(TodoData.class);
		mockListView = Mockito.mock(ListView.class);

		controller.todoListView = mockListView;

		ObservableList<TodoItem> mockTodoItems = FXCollections.observableArrayList();
		when(mockTodoData.getTodoItems()).thenReturn(mockTodoItems);
		when(mockListView.getItems()).thenReturn(mockTodoItems);
	}

	@Test
	public void testHandleKeyPressed() {
		TodoItem item = new TodoItem("Test", "Test details", LocalDate.now());
		ObservableList<TodoItem> mockTodoItems = FXCollections.observableArrayList(item);
		when(mockListView.getSelectionModel().getSelectedItem()).thenReturn(item);
		when(mockListView.getItems()).thenReturn(mockTodoItems);

		KeyEvent keyEvent = new KeyEvent(KeyEvent.KEY_PRESSED, "", "", KeyCode.DELETE, false, false, false, false);

		controller.handleKeyPressed(keyEvent);

		verify(mockTodoData, times(1)).deleteTodoItem(item);
	}
}
