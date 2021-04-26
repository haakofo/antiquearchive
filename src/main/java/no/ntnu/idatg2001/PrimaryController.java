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

    /**
     * Fields for the main controller. Creates a registry.
     */
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

    /**
     * Gets the tasks form the registry and returns them in an Observable arraylist.
     * @return
     */
    @FXML
    private ObservableList<Task> getTasks() {

        ObservableList<Task> tasksObservableList = FXCollections.observableArrayList();
        tasksObservableList.addAll(TaskRegistry.taskArrayList);

        return tasksObservableList;
    }

    /**
     * This prints the tasks found in the registry and throws two exceptions.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    @FXML
    public void print() throws IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        taskRegistry.printData();
    }

    /**
     * This method switches the app to the secondary controller.
     * @throws IOException
     */
    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    /**
     * This method is used when the user clicks the "Add" button.
     * @param event
     * @throws IOException
     */
    @FXML
    void addTask(MouseEvent event) throws IOException {
        switchToSecondary();
    }

    /**
     * This is the initialize method for the controller. It sets the correct Cell values and gets the tasks from the registry.
     * @throws IOException
     * @throws ClassNotFoundException
     */
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

    /**
     * This is the remove method for the controller. It removes the task that is clicked and will give you an alert if you haven't chosen any task or if there are none.
     */
    @FXML
    public void remove() {
        if (taskRegistry.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There is no tasks to remove");
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

        } else if (t1 == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You need to select a task to remove");
            alert.show();
        }

    }

    /**
     * This method changes the doig status of the selected task and gives an alert if no task is chosen or if there are none.
     */
    @FXML
    public void changeDoingStatus() {
        if (taskRegistry.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There is no tasks to change Status of");
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

        } else if (t1 == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("You need to select a task to change status!");
            alert.show();
        }

    }

    /**
     * This method exits the app and asks the user to confirm that they want to exit before exiting.
     * @param mouseEvent
     */
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