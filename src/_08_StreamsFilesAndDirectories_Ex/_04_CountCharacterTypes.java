package _08_StreamsFilesAndDirectories_Ex;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class _04_CountCharacterTypes {
    public static void main(String[] args) throws IOException {
        //    Write a program that reads a list of words from the file ("input.txt" from the Resources - Exercises)
        //    and finds the count of vowels, consonants, and punctuation marks. Assume that:
        //    • a, e, i, o, u are vowels, only lower case.
        //    • All others are consonants.
        //    • Punctuation marks are (! , . ?).
        //    • Do not count whitespace.


        int countVowels= 0;
        int countPunctuation= 0;
        int countConsonants= 0;
        
        Set<Character> vowels = getVowels();//вс. възможно големи букви 
        Set<Character> punctuationMarks = getPunctMarks();//вс. възможно пункт. знаци


        String pathIn = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/input.txt";
         List<String> allLines = Files.readAllLines(Path.of(pathIn)); 

         
         for(String line: allLines){
             for (int i = 0; i < line.length(); i++) {
                 char currentSymbol = line.charAt(i);
                 if(currentSymbol==' '){
                     continue;
                 }
                 if(vowels.contains(currentSymbol)){
                     countVowels++;
                 }
                 else if (punctuationMarks.contains(currentSymbol)){
                     countPunctuation++;
                 }
                 else {
                     countConsonants++;
                 }
                 
             }
         }
        BufferedWriter writer = new BufferedWriter(new FileWriter("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/outputTask4.txt"));
         writer.write("Vowels: " + countVowels);
         writer.newLine();
        writer.write("Other symbols: " + countConsonants);
        writer.newLine();
        writer.write("Punctuation: " + countPunctuation);
        writer.close();



    }

    private static Set<Character> getPunctMarks() {
        Set<Character>marks = new HashSet<>();
        marks.add('!');
        marks.add('?');
        marks.add(',');
        marks.add('.');
        return marks;
    }

    private static Set<Character> getVowels() {
        Set<Character>vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        return vowels;
    }
}
