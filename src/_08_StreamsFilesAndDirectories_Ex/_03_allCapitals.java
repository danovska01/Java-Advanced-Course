package _08_StreamsFilesAndDirectories_Ex;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class _03_allCapitals {
    public static void main(String[] args) throws IOException {
        String pathIn = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/input.txt";
        String pathOut = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/outputTask3.txt";
        try (BufferedReader br=Files.newBufferedReader(Paths.get(pathIn))){
            try (PrintWriter writer = new PrintWriter(Files.newBufferedWriter(Path.of(pathOut)))){
                String line = br.readLine().toUpperCase();
            while (true){
                writer.println(line);
                line= br.readLine().toUpperCase();
            }



        }}
        catch (IOException a) {
            a.printStackTrace();
        }


    }

}
