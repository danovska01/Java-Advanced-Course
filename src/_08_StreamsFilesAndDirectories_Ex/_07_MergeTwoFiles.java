package _08_StreamsFilesAndDirectories_Ex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _07_MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        //Write a program that reads the contents of two text files ("inputOne.txt", "inputTwo.txt" from Resources - Exercises) and merges them into a third one.

        String text1 = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/inputOne.txt";
        String text2 = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/inputTwo.txt";

        List <String>  mergedText = Files.readAllLines(Path.of(text1));
        mergedText.addAll(Files.readAllLines(Path.of(text2)));



        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/outputTask7.txt"));

        for (int i = 0; i < mergedText.size(); i++) {
            writer.write(mergedText.get(i));
            writer.newLine();
        }

        writer.close();





    }
}
