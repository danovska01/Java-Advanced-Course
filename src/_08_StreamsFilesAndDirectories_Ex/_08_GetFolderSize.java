package _08_StreamsFilesAndDirectories_Ex;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class _08_GetFolderSize {
    public static void main(String[] args) throws IOException {
        // Write a program that traverses a folder and calculates its size in bytes. Use Folder Exercises Resources in Resources.

        String basePath = "/home/kristina/Desktop/java/Java Advanced/Java Advanced/9. Exercise: Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        Path folder = Paths.get(basePath);

        long size = Files.walk(folder)
                .filter(p -> p.toFile().isFile())
                .mapToLong(p -> p.toFile().length())
                .sum();

        System.out.println(String.format("Folder size: %d", size));


    }
}
