package todo_list.filter;

import todo_list.datamodel.TodoItem;

public interface TodoItemFilter {
	boolean test(TodoItem item);
}
