package no.antiquearchive;

import java.io.*;
import java.util.ArrayList;


public class TaskRegistry {

    /**
     * Sets up a static arrayList for the registry.
     */
    static ArrayList<Item> itemArrayList = new ArrayList<>();

    /**
     * Method to add tasks, takes a task and adds it to the registry and writes it to the file.
     * @param item task to be added.
     */
    public void addTask(Item item) {
        itemArrayList.add(item);
        FileReadWrite.writeToFile(itemArrayList);

    }

    /**
     * Method that removes a task. Takes in the specific task to be removed.
     * @param itemRemove task object to remove.
     */
    public void removeSelectedTask(Item itemRemove) {
        itemArrayList.remove(itemRemove);
        FileReadWrite.writeToFile(itemArrayList);
    }

    /**
     * Checks if the registry is empty.
     * @return returns true if the list is empty and false if it isn't.
     */
    public boolean isEmpty() {
        if (itemArrayList.isEmpty()) {
            return true;
        } else
            return false;
    }

    /**
     * Simple method to print the data in the registry.
     */
    public void printData() {

        itemArrayList.forEach(s -> System.out.println(s.toString()));
    }

    /**
     * Simple method that reads the file where the registry is saved. Throws either a IO or ClassNotFound exception.
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public void readFromFile() throws IOException, ClassNotFoundException {
        itemArrayList = (ArrayList<Item>) FileReadWrite.readFromFile();
    }

    /**
     * Changes the "doing" status of the task.
     * @param status which status to be set.
     * @param givenItem task that will get a new status.
     */
    public void changeDoingStatus(String status, Item givenItem) {
        givenItem.setDoingStatus(status);
        FileReadWrite.writeToFile(itemArrayList);

    }

}
