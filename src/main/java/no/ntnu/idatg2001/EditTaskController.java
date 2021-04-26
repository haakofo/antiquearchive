package no.ntnu.idatg2001;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;

import java.io.IOException;
import java.time.LocalDate;

public class EditTaskController {
    TaskRegistry taskRegistry = new TaskRegistry();

    @FXML
    private TextField titleTextField;

    @FXML
    private TextField descriptionTextField;

    @FXML
    private ComboBox<?> priorityComboBox;

    @FXML
    private TextField categoryTextField;

    @FXML
    private DatePicker startDatePicker;

    @FXML
    private DatePicker finishDatePicker;

    private Task task;

    void setEditTask(Task task) {
        this.task = task;
    }

    String priority;
    @FXML
    private void setTask() throws IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        String title = titleTextField.getText();
        String description = descriptionTextField.getText();
        String category = categoryTextField.getText();
        priority = (String) priorityComboBox.getValue();
        LocalDate startDate = startDatePicker.getValue();
        LocalDate endDate = finishDatePicker.getValue();
        if (!titleTextField.getText().equals("") && priorityComboBox.getValue() != null && finishDatePicker.getValue() != null) {
            taskRegistry.addTask(new Task(title, priority, description, category, startDate, endDate));
            try {
                switchToPrimary();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You missed a required field");
            alert.show();
        }

    }

    @FXML
    private void cancelEdit(){
        taskRegistry.addTask(task);
        try {
            switchToPrimary();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }

    @FXML
    public void finishEdit() throws IOException {
        switchToPrimary();
    }

    @FXML
    public void initialize() {
        // Must use run later, since variable is passed after initial load.
        Platform.runLater(() -> {
            if (task != null) {
                //TODO: Fix her
                titleTextField.setText(task.getTitle());
                descriptionTextField.setText(task.getDescription());
                categoryTextField.setText(task.getCategory());
                int comboBoxIndex = priorityComboBox.getItems().indexOf(task.getPriority());
                priorityComboBox.getSelectionModel().select(comboBoxIndex);
                startDatePicker.setValue(task.getStartDate());
                finishDatePicker.setValue(task.getEndDate());

            }
        });
    }
}
