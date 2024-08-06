package todo_list;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import todo_list.datamodel.TodoData;
import todo_list.datamodel.TodoItem;

public class DialogController {

	@FXML
	private TextField shortDescriptionField;
	@FXML
	private TextArea detailsArea;
	@FXML
	private DatePicker deadlinePicker;

	public TodoItem processResults() {
		var shortDescription = shortDescriptionField.getText().trim();
		var details = detailsArea.getText().trim();
		var deadlineValue = deadlinePicker.getValue();
		var newItem = new TodoItem(shortDescription, details, deadlineValue);

		TodoData.getInstance().addTodoItem(newItem);
		return newItem;
	}
}
