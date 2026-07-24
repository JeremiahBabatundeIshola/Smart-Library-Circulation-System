package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {

    public void saveData(String data) {

        try {

            FileWriter writer = new FileWriter("library_data.txt");
            writer.write(data);
            writer.close();

            System.out.println("Data saved successfully");

        } catch (IOException e) {

            System.out.println("Error saving data");

        }
    }

    public String loadData() {

        StringBuilder data = new StringBuilder();

        try {

            BufferedReader reader =
                    new BufferedReader(
                            new FileReader("library_data.txt"));

            String line;

            while ((line = reader.readLine()) != null) {
                data.append(line).append("\n");
            }

            reader.close();

        } catch (Exception e) {

            System.out.println("Error loading data");

        }

        return data.toString();
    }
}