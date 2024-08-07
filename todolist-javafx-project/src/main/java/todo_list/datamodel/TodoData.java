package todo_list.datamodel;

import javafx.collections.FXCollections;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TodoData {

	private static TodoData instance = new TodoData();
	private static final String filename = "TodoListItems.txt";
	private final DateTimeFormatter formatter;
	private List<TodoItem> todoItems;

	private TodoData() {
		formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	}

	public static TodoData getInstance() {
		return instance;
	}

	public static void setInstance(TodoData instance) {
		TodoData.instance = instance;
	}

	public List<TodoItem> getTodoItems() {
		return todoItems;
	}

	public void addTodoItem(TodoItem item) {
		todoItems.add(item);
	}

	public void deleteTodoItem(TodoItem item) {
		todoItems.remove(item);
	}

	public void loadTodoItems() throws IOException {
		todoItems = FXCollections.observableArrayList();
		var path = Paths.get(filename);

		try (var buffReader = Files.newBufferedReader(path)) {
			String input;
			while ((input = buffReader.readLine()) != null) {
				var itemPieces = input.split("\\|\\|\\|");

				var shortDescription = itemPieces[0];
				var details = itemPieces[1];
				var dateString = itemPieces[2];

				var date = LocalDate.parse(dateString, formatter);
				var todoItem = new TodoItem(shortDescription, details, date);
				todoItems.add(todoItem);
			}
		}
	}

	public void storeTodoItems() throws IOException {
		var path = Paths.get(filename);
		try (var buffWriter = Files.newBufferedWriter(path)) {
			for (var item : todoItems) {
				buffWriter.write(String.format("%s|||%s|||%s", item.getShortDescription(), item.getDetails(),
						item.getDeadline().format(formatter)));
				buffWriter.newLine();
			}
		}
	}
}
