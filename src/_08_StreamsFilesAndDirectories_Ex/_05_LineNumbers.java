package _08_StreamsFilesAndDirectories_Ex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _05_LineNumbers {
    public static void main(String[] args) throws IOException {
        //Write a program that reads a text file ("inputLineNumbers.txt" from the Resources - Exercises)
        // and inserts line numbers in front of each of its lines. The result should be written to another text file – "output.txt".

        String pathIn = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/inputLineNumbers.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/outputTask5.txt"));

        List<String>allLines = Files.readAllLines(Path.of(pathIn));
        int counter = 1;


        for(String line : allLines){
            line= counter + ". "+ line;
            writer.write(line);
            writer.newLine();
            counter++;
        }
        writer.close();
    }
}
