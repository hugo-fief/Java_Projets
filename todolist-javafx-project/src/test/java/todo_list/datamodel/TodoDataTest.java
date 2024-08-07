package todo_list.datamodel;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TodoDataTest {

	private TodoData todoData;

	@BeforeEach
	public void setUp() {
		todoData = TodoData.getInstance();
		
		try {
			todoData.loadTodoItems();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testAddTodoItem() {
		TodoItem item = new TodoItem("Test", "Test details", LocalDate.now());
		todoData.addTodoItem(item);
		List<TodoItem> items = todoData.getTodoItems();
		assertTrue(items.contains(item));
	}

	@Test
	public void testDeleteTodoItem() {
		TodoItem item = new TodoItem("Test", "Test details", LocalDate.now());
		todoData.addTodoItem(item);
		todoData.deleteTodoItem(item);
		List<TodoItem> items = todoData.getTodoItems();
		assertTrue(!items.contains(item));
	}
}
