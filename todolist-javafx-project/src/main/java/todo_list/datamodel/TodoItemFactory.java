package todo_list.datamodel;

import java.time.LocalDate;

public class TodoItemFactory {

	public static TodoItem createTodoItem(String shortDescription, String details, LocalDate deadline) {
		return new TodoItem(shortDescription, details, deadline);
	}
}
