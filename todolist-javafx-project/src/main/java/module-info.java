module todo_list {
	requires javafx.controls;
	requires javafx.fxml;
	requires transitive javafx.graphics;

	opens todo_list to javafx.fxml;

	exports todo_list;
	exports todo_list.datamodel;
}
