package _08_StreamsFilesAndDirectories_Ex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class _06_WordCount {
    public static void main(String[] args) throws IOException {
        //Write a program that reads a list of words from the file "words.txt" (from the Resources - Exercises)
        // and finds how many times each of the words is contained in another file "text.txt" (from the Resources - Exercises). Matching should be case-insensitive.
        //Write the results in file "results.txt". Sort the words by frequency in descending order.

        String pathRead = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/words.txt";
        String pathFind = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/text.txt";

        List<String> allLines = Files.readAllLines(Path.of(pathRead));
        String results = String.valueOf(Files.readAllLines(Path.of(pathFind)));

        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < allLines.size(); i++) {
            String[] currentLine = allLines.get(i).split("\\s+");
            for (int j = 0; j < currentLine.length; j++) {
                String word = currentLine[j];

                if (results.contains(word)) {
                    int counter = 0;
                    String[] resultArr = results.split(" ");
                    for (int k = 0; k < resultArr.length; k++) {
                        if (resultArr[k].equals(word)) {
                            counter++;
                        }
                        words.put(word, counter);
                    }


                }
            }

        }
       // Write the results in file "results.txt". Sort the words by frequency in descending order.
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/resultsTask6.txt"));


        words.entrySet().stream().sorted((x, y) -> {
            return y.getValue().compareTo(x.getValue());
        }).forEach(entry-> {
            try {
                writer.write(entry.getKey() + " - " + entry.getValue());
                writer.newLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        writer.close();


    }
}
