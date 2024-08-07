package todo_list;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import todo_list.datamodel.TodoItem;
import todo_list.datamodel.TodoItemFactory;

public class DialogController {

	@FXML
	protected TextField shortDescriptionField;
	@FXML
	protected TextArea detailsArea;
	@FXML
	protected DatePicker deadlinePicker;

	public TodoItem processResults() {
		return TodoItemFactory.createTodoItem(shortDescriptionField.getText().trim(), detailsArea.getText().trim(),
				deadlinePicker.getValue());
	}

	public void updateItem(TodoItem item) {
		item.setShortDescription(shortDescriptionField.getText().trim());
		item.setDetails(detailsArea.getText().trim());
		item.setDeadline(deadlinePicker.getValue());
	}

	public void setFields(TodoItem item) {
		shortDescriptionField.setText(item.getShortDescription());
		detailsArea.setText(item.getDetails());
		deadlinePicker.setValue(item.getDeadline());
	}
}
