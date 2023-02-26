package _08_StreamsFilesAndDirectories_Ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_SumLines2 {
    public static void main(String[] args) throws IOException {
        String path = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        allLines.stream()
                .map(line->line.toCharArray())
                .forEach(arr ->{
                    int sum = 0;
                    for(char symbol: arr){
                        sum+=symbol;
                    }
                    System.out.println(sum);
                });
    }
}
