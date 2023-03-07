package _08_StreamsFilesAndDirectories_Ex;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _06_WordCount2 {
    public static void main(String[] args) throws IOException {

        String pathWordsForSearch = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/words.txt";
        String pathTextInWhichToFindWords = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/text.txt";

        Map<String, Integer> countWords = new HashMap<>();
        List<String> wordsForSearch = Files.readAllLines(Path.of(pathWordsForSearch));
        List<String> textInWhichWeSearch = Files.readAllLines(Path.of(pathTextInWhichToFindWords));


        for (String currentLine : wordsForSearch) {
            Arrays.stream(currentLine.split("\\s+")).forEach(word -> {
                countWords.put(word, 0);

            });
        }


        for (String line : textInWhichWeSearch) {
            Arrays.stream(line.split("\\s+")).forEach(word -> {

                if (countWords.containsKey(word)) {
                    int currentCount = countWords.get(word);
                    countWords.put(word, currentCount + 1);
                }
            });
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/resultsTask6_2.txt"));


        countWords.entrySet().stream().sorted((x, y) -> {
            return y.getValue().compareTo(x.getValue());
        }).forEach(entry -> {
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
