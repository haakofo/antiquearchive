package no.ntnu.idatg2001;

import java.io.*;
import java.util.ArrayList;

public class FileReadWrite {


public void writeToFile(ArrayList<Task> arrayList){

    try {

        FileOutputStream fileOut = new FileOutputStream("objectFile.txt");
        ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
        objectOut.writeObject(arrayList);
        objectOut.close();
        System.out.println("The Object  was succesfully written to a file");

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    public ArrayList<Task> ReadFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream("objectFile.txt");
        ObjectInputStream objectIn = new ObjectInputStream(fileIn);
        //System.out.println(objectIn.readObject().toString());
        ArrayList<Task> tasks = (ArrayList<Task>) objectIn.readObject();
        objectIn.close();
        //tasks.forEach(s -> System.out.println(s.toString()));
        return tasks;
        /*
        taskArrayList.clear();
        tasks.forEach(this::addTask);
        tasks.clear();
        */

    }

}
