package no.ntnu.idatg2001;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

import java.util.List;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;


public class FileReadWrite {

    /**
     * Sets up a Gson builder.
     */
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

    /**
     * This methods takes the arraylist and tries to write it to the json file and throws and Exception if it fails.
     * @param arrayList
     */
    public static void writeToFile(List<Task> arrayList) {

        try {

            FileOutputStream fileOut = new FileOutputStream("objectFile.json");

            String json;
            json = gson.toJson(arrayList);

            fileOut.write(json.getBytes(StandardCharsets.UTF_8));
            fileOut.close();
            System.out.println("The Object  was succesfully written to a file");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * This method reads from the file and returns a List with all the tasks found in the file.
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static List<Task> readFromFile() throws IOException, ClassNotFoundException {


        Reader reader = Files.newBufferedReader(Paths.get("objectFile.json"));


        return gson.fromJson(reader, new TypeToken<List<Task>>() {
        }.getType());


    }

}