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
    static Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(LocalDate.class, new LocalDateAdapter())
            .create();

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

    public static List<Task> readFromFile() throws IOException, ClassNotFoundException {


        Reader reader = Files.newBufferedReader(Paths.get("objectFile.json"));


        return gson.fromJson(reader, new TypeToken<List<Task>>() {
        }.getType());


    }

}