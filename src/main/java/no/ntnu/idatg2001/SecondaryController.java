package no.ntnu.idatg2001;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class SecondaryController {


    TaskRegistry taskRegistry = new TaskRegistry();
    PrimaryController primaryController = new PrimaryController();
    @FXML
    private TextField tf1;


    @FXML
    private TextField tf2;

    @FXML
    public Label warningLabel;

    @FXML
    private TextField tf3;
    @FXML
    private ComboBox<String> comboBox1;
    @FXML
    private DatePicker datePicker1;

    @FXML
    private DatePicker datePicker2;

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException, ClassNotFoundException {
        primaryController.print();
        App.setRoot("primary");
    }

    @FXML
    void setTask(ActionEvent event) throws IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        String title = tf1.getText();
        String description = tf2.getText();
        String category = tf3.getText();
        String priority = comboBox1.getValue();
        LocalDate startDate = datePicker1.getValue();
        LocalDate endDate = datePicker2.getValue();

        if (!tf1.getText().equals("") && comboBox1.getValue() != null && datePicker2.getValue() != null) {
            taskRegistry.addTask(new Task(title, priority, description, category, startDate, endDate));

            try {
                switchToPrimary(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            warningLabel.setText("required field missing");


    }

    @FXML
    void goBack(ActionEvent event) {
        try {
            switchToPrimary(event);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}