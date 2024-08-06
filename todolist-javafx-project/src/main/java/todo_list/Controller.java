package todo_list;

import javafx.application.Platform;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;
import todo_list.datamodel.TodoData;
import todo_list.datamodel.TodoItem;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Objects;
import java.util.function.Predicate;

public class Controller {

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;
    @FXML
    private Label deadlineLabel;
    @FXML
    private BorderPane mainBorderPane;
    @FXML
    private ContextMenu listContextMenu;
    @FXML
    private ToggleButton filterToggleButton;

    private FilteredList<TodoItem> filteredList;
    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodayItems;

    public void initialize() {
        listContextMenu = new ContextMenu();
        var deleteMenuItem = new MenuItem("Delete");
        deleteMenuItem.setOnAction(event -> {
            var item = todoListView.getSelectionModel().getSelectedItem();
            deleteItem(item);
        });

        listContextMenu.getItems().addAll(deleteMenuItem);
        todoListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                var item = todoListView.getSelectionModel().getSelectedItem();
                itemDetailsTextArea.setText(item.getDetails());

                var formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");
                deadlineLabel.setText(formatter.format(item.getDeadline()));
            }
        });

        wantAllItems = item -> true;
        wantTodayItems = todoItem -> todoItem.getDeadline().equals(LocalDate.now());

        filteredList = new FilteredList<>(TodoData.getInstance().getTodoItems(), wantAllItems);
        SortedList<TodoItem> sortedList = new SortedList<>(filteredList, Comparator.comparing(TodoItem::getDeadline));

        todoListView.setItems(sortedList);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        todoListView.getSelectionModel().selectFirst();

        todoListView.setCellFactory(new Callback<>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> todoItemListView) {
                var cell = new ListCell<TodoItem>() {
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) setText(null);
                        else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))) setTextFill(Color.RED);
                            else if (item.getDeadline().equals(LocalDate.now().plusDays(1))) setTextFill(Color.DARKORCHID);
                        }
                    }
                };

                cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                    if (isNowEmpty) cell.setContextMenu(null);
                    else cell.setContextMenu(listContextMenu);
                });

                return cell;
            }
        });
    }

    public void showNewItemDialog() throws IOException {
        var dialog = new Dialog<ButtonType>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
        dialog.setHeaderText("Use this dialog to create a new todo item");

        var fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItem-dialog.fxml"));
        dialog.getDialogPane().setContent(fxmlLoader.load());

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        var result = dialog.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) {
            var controller = (DialogController) fxmlLoader.getController();
            var newItem = controller.processResults();
            todoListView.getSelectionModel().select(newItem);
        }
    }

    public void deleteItem(TodoItem item) {
        var alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item: " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, CANCEL otherwise.");
        var result = alert.showAndWait();
        if (result.isPresent() && result.get().equals(ButtonType.OK)) TodoData.getInstance().deleteTodoItem(item);
    }

    public void handleKeyPressed(KeyEvent event) {
        var selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (Objects.nonNull(selectedItem)) if (event.getCode().equals(KeyCode.DELETE)) deleteItem(selectedItem);
    }

    public void handleFilterButton() {
        var selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if (filterToggleButton.isSelected()) {
            filteredList.setPredicate(wantTodayItems);
            if (filteredList.isEmpty()) {
                itemDetailsTextArea.clear();
                itemDetailsTextArea.setText("");
            }

            else if (filteredList.contains(selectedItem)) todoListView.getSelectionModel().select(selectedItem);
            else todoListView.getSelectionModel().selectFirst();
        } else {
            filteredList.setPredicate(wantAllItems);
            todoListView.getSelectionModel().select(selectedItem);
        }
    }

    public void handleExit() { Platform.exit(); }
}
