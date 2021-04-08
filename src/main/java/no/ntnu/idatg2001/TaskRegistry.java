package no.ntnu.idatg2001;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;


public class TaskRegistry {
    ArrayList<Task> taskArrayList = new ArrayList<>();



    public static void main(String[] args) throws IOException, ClassNotFoundException, ParseException {
        TaskRegistry taskRegistry = new TaskRegistry();
        //taskRegistry.fillWithTestData();

        taskRegistry.ReadFromFile();
        // taskRegistry.printData();
        taskRegistry.sortByEndDate();
        taskRegistry.changeDoingStatus("doing", 1);
        taskRegistry.printData();
    }


    public void addTask(Task task) {
        taskArrayList.add(task);
        WriteObjectToFile(taskArrayList);

    }


    public void WriteObjectToFile(Object serObj) {

        try {

            FileOutputStream fileOut = new FileOutputStream("objectFile.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            //System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    private void fillWithTestData() throws ParseException {
        addTask(new Task("cleaning", "low", "clean your room", "cleaning", LocalDate.of(2021, 4, 8), LocalDate.of(2022, 4, 9)));
        addTask(new Task("cleaning", "high", "clean the bathroom", "cleaning", LocalDate.of(2022, 4, 8), LocalDate.of(2021, 4, 11)));
        addTask(new Task("exercise dog", "medium", "walk the dog", "exercise", LocalDate.of(2020, 4, 8), LocalDate.of(2021, 3, 1)));
        addTask(new Task("cleaning", "low", "clean the kitchen", "cleaning", LocalDate.of(2021, 4, 10), LocalDate.of(2021, 5, 6)));




    }

    private void printData() {

        taskArrayList.forEach(s -> System.out.println(s.toString()));
    }

    private void ReadFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("objectFile.txt");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        //System.out.println(objectIn.readObject().toString());
        ArrayList<Task> tasks = (ArrayList<Task>) objectIn.readObject();
        objectIn.close();
        //tasks.forEach(s -> System.out.println(s.toString()));
        taskArrayList.clear();
        tasks.forEach(this::addTask);
        tasks.clear();
    }


    private void sortByStartDate(){
        taskArrayList.sort(Comparator.comparing(Task::getStartDate));

    }
    private void sortByEndDate(){
        taskArrayList.sort(Comparator.comparing(Task::getEndDate));
        //  taskArrayList.forEach(s -> System.out.println(s.toString()));
    }

    private void changeDoingStatus(String status, int index){
        taskArrayList.get(index).setDoingStatus(status);
    }



}
