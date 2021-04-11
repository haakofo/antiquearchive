package no.ntnu.idatg2001;

import java.io.IOException;
import java.time.LocalDate;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
        taskRegistry.fillWithTestData();

        for (Task task : taskRegistry.taskArrayList){
        tasksObservableList.add(task);}

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

    @FXML
    void addTask(MouseEvent event) throws IOException {
        switchToSecondary();
    }
    @FXML public void updateList(){
        //taskTableView.refresh();
        taskTableView.setItems(getTasks());
    }
    @FXML public void initialize(){
            taskTitle.setCellValueFactory(new PropertyValueFactory<Task, String>("Title"));
            taskDescription.setCellValueFactory(new PropertyValueFactory<Task, String>("Description"));
            taskCategory.setCellValueFactory(new PropertyValueFactory<Task, String>("Category"));
            taskPriority.setCellValueFactory(new PropertyValueFactory<Task, String>("Priority"));
            taskStartDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("StartDate"));
            taskEndDate.setCellValueFactory(new PropertyValueFactory<Task, LocalDate>("EndDate"));
            taskTableView.setItems(getTasks());
    }


}