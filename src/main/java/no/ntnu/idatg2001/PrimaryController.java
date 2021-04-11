package no.ntnu.idatg2001;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
    TaskRegistry taskRegistry = new TaskRegistry();


    @FXML
    void sortTasksStart(MouseEvent event) throws ParseException, IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        taskRegistry.sortByStartDate();

    }

    @FXML
    public void print() throws IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        taskRegistry.printData();
    }

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void addTask(MouseEvent event) throws IOException {
        switchToSecondary();
    }
}