package _07_StreamsFilesAndDirectories;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03_CopyBytes {
    public static void main(String[] args) {
        //Read the file named "input.txt" and write to another file every character's ASCII representation.
        //Write every space or newline as it is, e.g. as a space or a new line.

        String pathIN = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input.txt";
        String pathOUT = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/outputTask3.txt";

        try(FileInputStream in = new FileInputStream(pathIN)){
            try(FileOutputStream out = new FileOutputStream(pathOUT)){
                int oneByte = in.read();
                while (oneByte>=0){
                    if(oneByte==32 || oneByte==10){
                        out.write((char)oneByte);
                    }else {
                        String digits = String.valueOf(oneByte);
                        for (int i = 0; i < digits.length(); i++) {
                            out.write(digits.charAt(i));

                        }
                    }
                    oneByte= in.read();
                }

            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
