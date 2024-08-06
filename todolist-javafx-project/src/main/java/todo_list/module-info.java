module todo_list {
    requires javafx.controls;
    requires javafx.fxml;

    opens todo_list to javafx.fxml;
    exports todo_list;
}