package _08_StreamsFilesAndDirectories_Ex;

import java.io.*;

public class _01_SumLines {
    public static void main(String[] args) throws IOException {
        //Write a program that reads a text file ("input.txt" from the Resources - Exercises) and prints on the console the sum of the ASCII
        // symbols of each of its lines. Use BufferedReader in combination with FileReader.

        String path = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/input.txt";
        FileReader fr=new FileReader(path);
        BufferedReader br=new BufferedReader(fr);
        int sum = 0;

        String line = br.readLine();
        while (line!=null) {

            for (int i = 0; i < line.length(); i++) {
                int character = line.charAt(i);
                sum += character;
            }
            System.out.println(sum);
            sum=0;
            line= br.readLine();

        }

    }
}
