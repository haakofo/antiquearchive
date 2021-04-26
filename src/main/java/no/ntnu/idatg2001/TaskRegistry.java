package no.ntnu.idatg2001;

import java.io.*;
import java.util.ArrayList;


public class TaskRegistry {

    /**
     * Sets up a static arrayList for the registry.
     */
    static ArrayList<Task> taskArrayList = new ArrayList<>();

    /**
     * Method to add tasks, takes a task and adds it to the registry and writes it to the file.
     * @param task task to be added.
     */
    public void addTask(Task task) {
        taskArrayList.add(task);
        FileReadWrite.writeToFile(taskArrayList);

    }

    /**
     * Method that removes a task. Takes in the specific task to be removed.
     * @param taskRemove task object to remove.
     */
    public void removeSelectedTask(Task taskRemove) {
        taskArrayList.remove(taskRemove);
        FileReadWrite.writeToFile(taskArrayList);
    }

    /**
     * Checks if the registry is empty.
     * @return returns true if the list is empty and false if it isn't.
     */
    public boolean isEmpty() {
        if (taskArrayList.isEmpty()) {
            return true;
        } else
            return false;
    }

    /**
     * Simple method to print the data in the registry.
     */
    public void printData() {

        taskArrayList.forEach(s -> System.out.println(s.toString()));
    }

    /**
     * Simple method that reads the file where the registry is saved. Throws either a IO or ClassNotFound exception.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void readFromFile() throws IOException, ClassNotFoundException {
        taskArrayList = (ArrayList<Task>) FileReadWrite.readFromFile();
    }

    /**
     * Changes the "doing" status of the task.
     * @param status which status to be set.
     * @param givenTask task that will get a new status.
     */
    public void changeDoingStatus(String status, Task givenTask) {
        givenTask.setDoingStatus(status);
        FileReadWrite.writeToFile(taskArrayList);

    }

}
