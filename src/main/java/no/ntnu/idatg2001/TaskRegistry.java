package no.ntnu.idatg2001;

import java.io.*;
import java.util.ArrayList;


public class TaskRegistry {

    static ArrayList<Task> taskArrayList = new ArrayList<>();


    public void addTask(Task task) {
        taskArrayList.add(task);
        FileReadWrite.writeToFile(taskArrayList);

    }


    public void removeSelectedTask(Task taskRemove) {
        taskArrayList.remove(taskRemove);
        FileReadWrite.writeToFile(taskArrayList);
    }

    public boolean isEmpty() {
        if (taskArrayList.isEmpty()) {
            return true;
        } else
            return false;
    }


    public void printData() {

        taskArrayList.forEach(s -> System.out.println(s.toString()));
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
        taskArrayList = (ArrayList<Task>) FileReadWrite.readFromFile();
    }


    public void changeDoingStatus(String status, Task givenTask) {
        givenTask.setDoingStatus(status);
        FileReadWrite.writeToFile(taskArrayList);

    }

}
