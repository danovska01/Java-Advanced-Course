package _07_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class _02_WriteToFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read the file named "input.txt" that is provided for this exercise and write all its content
        // to a file while skipping any punctuation. Skip the following symbols: ",", ".", "!", "?".
        String pathIN = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input.txt";
        String pathOUT = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input2.txt";

        Set<Character> forbiddenSymbols = new HashSet<>();
        Collections.addAll(forbiddenSymbols, '.', ',', '!', '?');

        try (FileInputStream in = new FileInputStream(pathIN)) {
            try (FileOutputStream out = new FileOutputStream(pathOUT)) {

                int oneByte = in.read();
                while (oneByte >= 0) {
                    char myByteChar = (char) oneByte;
                    if (!forbiddenSymbols.contains(myByteChar)) {
                        out.write(oneByte);
                    }
                    oneByte = in.read();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
