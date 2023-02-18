package _07_StreamsFilesAndDirectories;

import java.io.File;
import java.util.*;

public class _08_NestedFolders {
    public static void main(String[] args) {

        File dir = new File("/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/Files-and-Streams");
        Deque<File> files = new ArrayDeque<>();
        files.addLast(dir);
        List<String> folders = new ArrayList<>();

        while (! files.isEmpty()) {
            File currentDir = files.removeFirst();
            if (currentDir.isDirectory()) {
                for (File file : Objects.requireNonNull(currentDir.listFiles())) {
                    if (file.isDirectory()) {
                        files.addLast(file);
                    }
                }
                folders.add(currentDir.getName());
            }
        }
        folders.forEach(System.out::println);
        System.out.println(String.format("%d folders", folders.size()));
    }
}
