package todo_list;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
        return new TodoItem(shortDescription, details, deadlineValue);
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
