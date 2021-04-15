package no.ntnu.idatg2001;

import java.io.*;
import java.lang.reflect.Array;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


public class TaskRegistry {

    static ArrayList<Task> taskArrayList = new ArrayList<>();

    FileReadWrite fileReadWrite = new FileReadWrite();



    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TaskRegistry taskRegistry = new TaskRegistry();


        //taskRegistry.fillWithTestData();
        taskRegistry.readFromFile();
        //taskRegistry.ReadFromFile();
        // taskRegistry.printData();
        taskRegistry.sortByEndDate();
        taskRegistry.printData();
    }


    public void addTask(Task task) {
        taskArrayList.add(task);
       // WriteObjectToFile(taskArrayList);
        fileReadWrite.writeToFile(taskArrayList);

    }
    public void removeTask(int index){
        taskArrayList.remove(index);
        fileReadWrite.writeToFile(taskArrayList);

    }

    public void removeSelectedTask(Task taskRemove)
    {
        taskArrayList.remove(taskRemove);
        fileReadWrite.writeToFile(taskArrayList);
    }

    public boolean isEmpty()
    {
        if(taskArrayList.isEmpty())
        {
            return true;
        } else
            return false;
    }
/*
private void readFile() throws IOException, ClassNotFoundException {
        taskArrayList.clear();
    taskArrayList.addAll(fileReadWrite.ReadFromFile());
}

 */

    public void fillWithTestData()  {
        addTask(new Task("cleaning", "low", "clean your room", "cleaning", LocalDate.of(2021, 4, 8), LocalDate.of(2022, 4, 9)));
        addTask(new Task("cleaning", "high", "clean the bathroom", "cleaning", LocalDate.of(2022, 4, 8), LocalDate.of(2021, 4, 11)));
        addTask(new Task("exercise dog", "medium", "walk the dog", "exercise", LocalDate.of(2020, 4, 8), LocalDate.of(2021, 3, 1)));
        addTask(new Task("cleaning", "low", "clean the kitchen", "cleaning", LocalDate.of(2021, 4, 10), LocalDate.of(2021, 5, 6)));




    }

    public void printData() {

        taskArrayList.forEach(s -> System.out.println(s.toString()));
    }

    public void readFromFile() throws IOException, ClassNotFoundException {
       taskArrayList = (ArrayList<Task>) FileReadWrite.readFromFile();
    }

    public List<Task> getReg()
    {
        return taskArrayList;
    }


    public void sortByStartDate(){
        taskArrayList.sort(Comparator.comparing(Task::getStartDate));
        taskArrayList.forEach(s -> System.out.println(s.toString()));

    }
    private void sortByEndDate(){
        taskArrayList.sort(Comparator.comparing(Task::getEndDate));
        //  taskArrayList.forEach(s -> System.out.println(s.toString()));
    }

    private void changeDoingStatus(String status, int index){
        taskArrayList.get(index).setDoingStatus(status);
    }

}
