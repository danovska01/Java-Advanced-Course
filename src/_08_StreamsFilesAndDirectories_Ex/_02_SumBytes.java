package _08_StreamsFilesAndDirectories_Ex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _02_SumBytes {
    public static void main(String[] args) {
        // Write a program that reads a text file ("input.txt" from the Resources - Exercises) and prints on the console the sum of
        // the ASCII symbols of all characters inside of the file. Use BufferedReader in combination with FileReader.

        String path = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/input.txt";


            try (BufferedReader br=Files.newBufferedReader(Paths.get(path))){

                int sum = 0;

                String line = br.readLine();
                while (line!=null) {

                    for (int i = 0; i < line.length(); i++) {
                        int character = line.charAt(i);
                        sum += character;
                    }
                    line= br.readLine();

                }
                System.out.println(sum);

            }
            catch (IOException a) {
                a.printStackTrace();
            }

    }
}
