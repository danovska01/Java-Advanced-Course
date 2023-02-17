package _07_StreamsFilesAndDirectories;

import java.io.*;
import java.util.Scanner;

public class _05_WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        // Read the file provided, named "input.txt" and write to another file all lines which number is divisible by 3. Line numbers start from one.

        String pathIN = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/input.txt";
        String pathOUT = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/outputTask5.txt";

        Scanner in = new Scanner(new FileReader(pathIN));
        PrintWriter out = new PrintWriter(new FileWriter(pathOUT));

        String line = in.nextLine();
        int counter = 1;
        while (in.hasNextLine()) {
            if (counter % 3 == 0) {
                out.println(line);
            }
            counter++;
            line = in.nextLine();
            // out.flush(); - Може направо в цикъла да го сложим и да запаметява всеки път каквото иам в буферната памет към файла
        }
        // read every line from inPath
        // write every 3d line in the outPath

        // out.flush();
        out.close();

    }

}

