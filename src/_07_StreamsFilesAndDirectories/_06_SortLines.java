package _07_StreamsFilesAndDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class _06_SortLines {
    public static void main(String[] args) throws IOException {


    String pathIN = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input.txt";
    String pathOUT = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/outputTask6.txt";


    Path input = Paths.get(pathIN);
    Path output = Paths.get(pathOUT);
        List<String> lines = Files.readAllLines(input);
        Collections.sort(lines);
        Files.write(output,lines);
}
}
