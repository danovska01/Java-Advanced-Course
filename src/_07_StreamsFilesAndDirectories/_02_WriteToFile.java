package _07_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class _02_WriteToFile {
    public static void main(String[] args) {
        String pathIN = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input.txt";
        String pathOUT = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/output.txt";
        Set<Character> forbiddenSymbols = new HashSet<>();
        Collections.addAll(forbiddenSymbols, ',', '.', '?', '!');

        try(FileInputStream in = new FileInputStream(pathIN)){
            try (FileOutputStream out = new FileOutputStream(pathOUT)){
                int oneByte = in.read();
                while (oneByte>=0){
                    char myByteAsChar = (char) oneByte;
                    if(!forbiddenSymbols.contains(myByteAsChar)){
                        out.write(oneByte);
                    }
                    oneByte=in.read();
                }

            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}
