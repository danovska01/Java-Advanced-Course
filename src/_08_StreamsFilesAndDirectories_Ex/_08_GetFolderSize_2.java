package _08_StreamsFilesAndDirectories_Ex;

import java.io.File;

public class _08_GetFolderSize_2 {
    public static void main(String[] args) {
        // 1. достъп до папката
        // 2. обхождане вс. файлове в папката -> всеки файл му звимаме размера и сумираме
        // 3. печатаме общия размер на папките
        String path = "/home/kristina/Desktop/java/Java Advanced/Java Advanced/9. Exercise: Streams, Files and Directories/04. Java-Advanced-Files-and-Streams-Exercises-Resources/Exercises Resources";
        File folder = new File(path);
        File [] allFiles = folder.listFiles();
        int folderSize = 0;
        for(File file: allFiles){
            folderSize+=file.length();
        }
        System.out.println(String.format("Folder size: %d", folderSize));

    }




}
