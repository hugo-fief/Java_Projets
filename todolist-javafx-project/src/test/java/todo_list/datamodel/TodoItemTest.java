package todo_list.datamodel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemTest {

	@Test
	public void testTodoItem() {
		TodoItem item = new TodoItem("Test", "Test details", LocalDate.now());
		assertEquals("Test", item.getShortDescription());
		assertEquals("Test details", item.getDetails());
		assertEquals(LocalDate.now(), item.getDeadline());
	}
}
