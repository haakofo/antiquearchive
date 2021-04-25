package no.ntnu.idatg2001;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class PrimaryController {


    TaskRegistry taskRegistry = new TaskRegistry();
    @FXML
    public Button exitButton;
    @FXML
    private TableView<Task> taskTableView;
    @FXML
    private TableColumn<Task, String> taskTitle;
    @FXML
    private TableColumn<Task, String> taskDescription;
    @FXML
    private TableColumn<Task, String> taskCategory;
    @FXML
    private TableColumn<Task, String> taskPriority;
    @FXML
    private TableColumn<Task, LocalDate> taskStartDate;
    @FXML
    private TableColumn<Task, LocalDate> taskEndDate;
    @FXML
    private TableColumn<Task, String> doingStatus;

    @FXML
    public Task taskToEdit;


    @FXML
    private ObservableList<Task> getTasks() {

        ObservableList<Task> tasksObservableList = FXCollections.observableArrayList();
        tasksObservableList.addAll(TaskRegistry.taskArrayList);

        return tasksObservableList;
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

    private void switchToEdit() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tertiary.fxml"));
        Parent root = fxmlLoader.load();
        EditTaskController editTaskController = fxmlLoader.getController();
        editTaskController.setEditTask(taskTableView.getSelectionModel().getSelectedItem());
        App.setRoot(root);
    }

    @FXML
    void addTask(MouseEvent event) throws IOException {
        switchToSecondary();
    }

    @FXML
    public void editTask() {
        if (taskRegistry.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There are no tasks to edit");
            alert.show();
            return;
        }

        taskToEdit = taskTableView.getSelectionModel().getSelectedItem();
        if (taskToEdit != null) {
            try {
                switchToEdit();
            } catch (IOException e) {
                e.printStackTrace();
            }

            taskRegistry.removeSelectedTask(taskToEdit);
            taskTableView.setItems(getTasks());

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You need to select a task to edit");
            alert.show();
        }

    }


    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        taskTitle.setCellValueFactory(new PropertyValueFactory<Task, String>("Title"));
        taskDescription.setCellValueFactory(new PropertyValueFactory<Task, String>("Description"));
        taskCategory.setCellValueFactory(new PropertyValueFactory<Task, String>("Category"));
        taskPriority.setCellValueFactory(new PropertyValueFactory<Task, String>("Priority"));
        taskStartDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("StartDate"));
        taskEndDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("EndDate"));
        doingStatus.setCellValueFactory(new PropertyValueFactory<Task, String>("doingStatus"));
        taskTableView.refresh();
        taskTableView.setItems(getTasks());

    }

    @FXML
    public void remove() {
        if (taskRegistry.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There are no tasks to remove");
            alert.show();
            return;
        }

        Task t1 = taskTableView.getSelectionModel().getSelectedItem();
        if (t1 != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to remove task?", ButtonType.YES, ButtonType.NO);
            alert.showAndWait();

            if (alert.getResult() == ButtonType.YES) {
                taskRegistry.removeSelectedTask(t1);
                taskTableView.setItems(getTasks());
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You need to select a task to remove");
            alert.show();
        }

    }

    @FXML
    public void changeDoingStatus() {
        if (taskRegistry.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There are no tasks to change Status of");
            alert.show();
            return;
        }

        Task t1 = taskTableView.getSelectionModel().getSelectedItem();
        if (t1 != null) {
            if (t1.getDoingStatus().equalsIgnoreCase("toDo")) {
                taskRegistry.changeDoingStatus("done", t1);
            } else {
                taskRegistry.changeDoingStatus("todo", t1);
            }


            taskTableView.refresh();

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You need to select a task to change status!");
            alert.show();
        }

    }

    public void exit(ActionEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Are you sure you want to exit program?", ButtonType.YES, ButtonType.NO);
        alert.showAndWait();

        if (alert.getResult() == ButtonType.YES) {

            Stage stage = (Stage) exitButton.getScene().getWindow();
            // do what you have to do
            stage.close();
        }
    }

}