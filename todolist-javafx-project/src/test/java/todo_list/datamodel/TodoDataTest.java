package todo_list.datamodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoDataTest {

	private TodoData todoData;

	@BeforeEach
	public void setUp() {
		todoData = TodoData.getInstance();
		todoData.getTodoItems().clear(); // Clear items before each test
	}

	@Test
	public void testAddTodoItem() {
		TodoItem item = new TodoItem("Test", "Test details", LocalDate.now());
		todoData.addTodoItem(item);

		assertEquals(1, todoData.getTodoItems().size());
		assertTrue(todoData.getTodoItems().contains(item));
	}

	@Test
	public void testDeleteTodoItem() {
		TodoItem item = new TodoItem("Test", "Test details", LocalDate.now());
		todoData.addTodoItem(item);
		todoData.deleteTodoItem(item);

		assertEquals(0, todoData.getTodoItems().size());
	}
}
