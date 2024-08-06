package com.taskmanagerjfx;

import com.taskmanager.Task;
import com.taskmanager.TaskPriority;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class TaskOverviewController {
    @FXML
    private TableView<Task> taskTable;
    @FXML
    private TableColumn<Task, String> titleColumn;
    @FXML
    private TableColumn<Task, String> descriptionColumn;

    private ObservableList<Task> taskData = FXCollections.observableArrayList();

    public TaskOverviewController() {
        // Add some sample data
        taskData.add(new Task("Buy milk", "Buy milk from the supermarket", TaskPriority.HIGH));
        taskData.add(new Task("Clean the room", "Tidy up and clean the room", TaskPriority.MEDIUM));
    }

    @FXML
    private void initialize() {
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));

        taskTable.setItems(taskData);
    }
}

