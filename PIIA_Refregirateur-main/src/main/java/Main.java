import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
    private final String FXML_FILE_PATH = "/FXML/Configuration.fxml";

    private Scene scene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load FXML files and create scenes
        Parent root1 = FXMLLoader.load(getClass().getResource(FXML_FILE_PATH));
        scene = new Scene(root1);


        // Set scene1 as the initial scene
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
