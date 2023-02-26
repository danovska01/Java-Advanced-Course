package _08_StreamsFilesAndDirectories_Ex;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class _01_SumLines1 {
    public static void main(String[] args) throws IOException {
        String path = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/input.txt";
        List<String> allLines = Files.readAllLines(Path.of(path));
        for(String line: allLines){
            int sum = 0; //сумата за всеки един ред
            // намирам сумата от ascii-> print сумата
            for (int i = 0; i < line.length(); i++) {
                char currentSymbol= line.charAt(i);
                sum+=currentSymbol;
            }
            System.out.println(sum);
        }
    }
}
