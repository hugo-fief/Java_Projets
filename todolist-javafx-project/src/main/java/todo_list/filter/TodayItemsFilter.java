package todo_list.filter;

import java.time.LocalDate;

import todo_list.datamodel.TodoItem;

public class TodayItemsFilter implements TodoItemFilter {
	@Override
	public boolean test(TodoItem item) {
		return item.getDeadline().equals(LocalDate.now());
	}
}
