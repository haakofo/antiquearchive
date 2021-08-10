package no.antiquearchive;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    /**
     * Sets up a private static scene.
     */
    private static Scene scene;

    /**
     * Start method that starts the app.
     * @param stage the stage of the app.
     * @throws IOException
     */
    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Method that sets the root(FXML file).
     * @param fxml
     * @throws IOException
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static void setRoot(Parent root) throws IOException{
        scene.setRoot(root);
    }

    /**
     * Loads chosen FXML file.
     * @param fxml FXML file to be loaded.
     * @return returns the loaded FXML file.
     * @throws IOException
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    /**
     * The main method only has the launch method.
     * @param args
     */
    public static void main(String[] args) {
        launch();
    }

}