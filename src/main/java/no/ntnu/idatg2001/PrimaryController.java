package no.ntnu.idatg2001;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class PrimaryController {
    TaskRegistry taskRegistry = new TaskRegistry();

    @FXML private TableView<Task> taskTableView;
    @FXML private TableColumn<Task, String> taskTitle;
    @FXML private TableColumn<Task,String> taskDescription;
    @FXML private TableColumn<Task,String> taskCategory;
    @FXML private TableColumn<Task,String> taskPriority;
    @FXML private TableColumn<Task,LocalDate> taskStartDate;
    @FXML private TableColumn<Task, LocalDate> taskEndDate;
    @FXML private TextField taskDelete;
    @FXML
    private TableView createTableView(){

        taskTableView.setItems(this.getTasks());
        //tableView.setItems(FXCollections.observableList(this.getStudentArrayList()));
        return taskTableView;
    }
    /*
    @FXML
    void sortTasksStart(MouseEvent event) throws ParseException, IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        taskRegistry.sortByStartDate();

    } */
    @FXML
    private ObservableList<Task> getTasks(){

        ObservableList<Task> tasksObservableList = FXCollections.observableArrayList();
        tasksObservableList.addAll(taskRegistry.taskArrayList);

        return tasksObservableList;
    }

    @FXML
    public void print() throws IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
        taskRegistry.printData();
    }

    @FXML
    void updateTable(MouseEvent event) {
        ObservableList<Task> getTasks1 = this.getTasks();
        System.out.println("get tasks");
        taskTableView.setItems(getTasks1);
    }


    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }

    @FXML
    void addTask(MouseEvent event) throws IOException {
        switchToSecondary();
    }
    @FXML public void updateList(){
        taskTableView.refresh();
        taskTableView.setItems(getTasks());
    }
    @FXML public void initialize() throws IOException, ClassNotFoundException {
        taskRegistry.readFromFile();
            taskTitle.setCellValueFactory(new PropertyValueFactory<Task, String>("Title"));
            taskDescription.setCellValueFactory(new PropertyValueFactory<Task, String>("Description"));
            taskCategory.setCellValueFactory(new PropertyValueFactory<Task, String>("Category"));
            taskPriority.setCellValueFactory(new PropertyValueFactory<Task, String>("Priority"));
            taskStartDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("StartDate"));
            taskEndDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("EndDate"));
            taskTableView.refresh();
            taskTableView.setItems(getTasks());

    }

    @FXML public void remove()
    {
        if(taskRegistry.isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("There is no tasks to remove!");
            alert.show();
            return;
        }

        Task t1 = taskTableView.getSelectionModel().getSelectedItem();
        if(t1 != null)
        {
            taskRegistry.removeSelectedTask(t1);
            taskTableView.setItems(getTasks());
        }
        else if(t1 == null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText("You need to select a task to remove!");
                alert.show();
            }

    }

}