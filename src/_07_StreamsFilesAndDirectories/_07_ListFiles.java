package _07_StreamsFilesAndDirectories;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

public class _07_ListFiles {
    public static void main(String[] args) {
        //You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes)
        // of all files that are placed directly in it (do not include files in nested folders).
        //Use the File class and its method listFiles().

        File file = new File("/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/Files-and-Streams");
        if(file.exists()){
            if(file.isDirectory()){
                File [] files = file.listFiles();
                if (files != null) {
                    for(File f: files){
                        if(!f.isDirectory()){
                            System.out.printf("%s: [%s]%n", f.getName(), f.length());
                        }
                    }
                }
            }
        }
    }
}
