package _07_StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class _04_ExtractIntegers {
    public static void main(String[] args) throws IOException {
        //Read the file provided, named "input.txt" and extracts all integers that are not a part of a word in a separate file.
        // A valid integer is surrounded by white spaces.
        // Wrap a FileInputStream in a Scanner and use the methods, hasNext(), hasNextInt() and nextInt()

        String pathIN = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input.txt";
        String pathOUT = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/outputTask4.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIN));
        PrintWriter myFileOutput = new PrintWriter(new FileOutputStream(pathOUT));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                int myNumber = scanner.nextInt();
                // System.out.println(myNumber);
                myFileOutput.println(myNumber);


            }
            scanner.next();
        }
        myFileOutput.close();



    }
}
