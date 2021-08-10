package no.antiquearchive;

import java.io.IOException;
import java.time.LocalDate;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


public class AddTaskController {

    /**
     * Creates the registry and a primary controller object so that the controller can be switched.
     * Also declares the labels,texfields, etc.
     */
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

    /**
     * This method switched back to the primary controller when the "Add" button is clicked.
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException, ClassNotFoundException {
        primaryController.print();
        App.setRoot("primary");
    }

    /**
     * This method adds the task with the text taken from the textfields.Then it uses the switchToPrimary to switch controller.
     * @param event
     * @throws IOException
     * @throws ClassNotFoundException
     */
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
            taskRegistry.addTask(new Item(title, priority, description, category, startDate, endDate));

            try {
                switchToPrimary(event);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else
            warningLabel.setText("Required field missing");


    }

    /**
     * This method is used when the "Go back" button is chosen and takes the user back to the first window (main controller).
     * @param event
     */
    @FXML
    void goBack(ActionEvent event) {
        try {
            switchToPrimary(event);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}