package _08_StreamsFilesAndDirectories_Ex;

import java.io.*;

public class _09_CopyAPicture {
    public static void main(String[] args) throws IOException {
        String inPath = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/Lara9.jpg";
        String outPath = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/Lara9COPY.jpg";

        InputStream in = new FileInputStream(inPath);
        OutputStream out = new FileOutputStream(outPath);

        byte[] allBytes = in.readAllBytes();
        out.write(allBytes);
    }
}
