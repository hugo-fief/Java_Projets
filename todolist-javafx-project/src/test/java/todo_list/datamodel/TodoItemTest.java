package todo_list.datamodel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TodoItemTest {

	@Test
	public void testTodoItemCreation() {
		String shortDescription = "Test Description";
		String details = "Test Details";
		LocalDate deadline = LocalDate.now();

		TodoItem item = new TodoItem(shortDescription, details, deadline);

		assertEquals(shortDescription, item.getShortDescription());
		assertEquals(details, item.getDetails());
		assertEquals(deadline, item.getDeadline());
	}
}
