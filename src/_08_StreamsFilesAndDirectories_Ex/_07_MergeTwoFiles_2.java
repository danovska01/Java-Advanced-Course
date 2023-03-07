package _08_StreamsFilesAndDirectories_Ex;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _07_MergeTwoFiles_2 {
    public static void main(String[] args) throws IOException {
        String pathFileOne = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/inputOne.txt";
        String pathFileTwo = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/inputTwo.txt";

        PrintWriter writer = new PrintWriter("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/outputTask7_2.txt");

        List<String> allLinesFileOne = Files.readAllLines(Path.of(pathFileOne));
        allLinesFileOne.forEach(line->writer.println(line));
        List<String> allLinesFileTwo = Files.readAllLines(Path.of(pathFileTwo));
        allLinesFileTwo.forEach(line->writer.println(line));
        writer.close();
    }
}
