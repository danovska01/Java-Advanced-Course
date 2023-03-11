package _09_FunctionalProgramming;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

public class _03_CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that reads one line of text from the console. Print the count of words that start with an Uppercase letter,
        // after that print all these words in the same order, as you found them in the text.
        //Use a Predicate<String>.

        String [] text = scanner.nextLine().split(" ");
        Predicate<String> checkerUpperCase =
                word -> Character.isUpperCase(word.charAt(0));

        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < text.length; i++) {
            if (checkerUpperCase.test(text[i]))
                result.add(text[i]);
        }
        System.out.println(result.size());
        for(String word: result){
            System.out.println(word);
        }

    }
}
