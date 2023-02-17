package _07_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class _01_ReadFile {
    public static void main(String[] args) {
        //You are given a file named "input.txt". Read and print all of its contents as a sequence of bytes
        // (the binary representation of the ASCII code for each character) separated by a single comma.

        String path = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input.txt";
        //String path = "/home/kristina/Desktop/java/Java Advanced/Java Advanced/8. Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Lab-Resources/input2.txt";
        try (FileInputStream fileStream = new FileInputStream(path)){
            //Use the read() method to read each byte of the file until it returns -1.
            int oneByte = fileStream.read();
            while (oneByte>=0){
                System.out.printf("%s ", Integer.toBinaryString(oneByte));
                oneByte=fileStream.read();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
