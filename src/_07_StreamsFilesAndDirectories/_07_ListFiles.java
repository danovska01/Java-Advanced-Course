package _07_StreamsFilesAndDirectories;

import java.io.File;
public class _07_ListFiles {
    public static void main(String[] args) {
        //You are provided a folder named "Files-and-Streams". Create a program that lists the names and file sizes (in bytes)
        // of all files that are placed directly in it (do not include files in nested folders).
        //Use the File class and its method listFiles().

        File folder = new File("/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/Files-and-Streams");

        if(folder.exists()){
            if(folder.isDirectory()){
                File [] listOfFiles = folder.listFiles();
                if (listOfFiles != null) {
                    for(File f: listOfFiles){
                        if(!f.isDirectory()){
                            System.out.printf("%s: [%s]%n", f.getName(), f.length());
                        }
                    }
                }
            }
        }
    }
}
