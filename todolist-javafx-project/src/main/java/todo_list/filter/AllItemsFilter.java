package todo_list.filter;

import todo_list.datamodel.TodoItem;

public class AllItemsFilter implements TodoItemFilter {
	@Override
	public boolean test(TodoItem item) {
		return true;
	}
}
