package todo_list;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import todo_list.datamodel.TodoData;

import java.io.IOException;

@SuppressWarnings("unused")
public class Main extends Application {

    private static Scene scene;

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String... args) {
        launch();
    }

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("main-window"), 900, 500);
        stage.setResizable(false);
        stage.setTitle("TODO List v1");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void stop() throws IOException {
        TodoData.getInstance().storeTodoItems();
    }

    @Override
    public void init() throws Exception {
        TodoData.getInstance().loadTodoItems();
    }
}