package _10_FunctionalProgramming_Ex;

import java.util.Scanner;
import java.util.function.Consumer;

public class _01_ConsumerPrint {
    public static void main(String[] args) {


    Scanner scanner = new Scanner(System.in);
    //Write a program that reads a collection of strings, separated by one or more whitespaces, from the console and then prints them onto the console.
    // Each string should be printed on a new line. Use a Consumer<T>.

    String [] names = scanner.nextLine().split("\\s+");
    Consumer<String> printer = e -> System.out.println(e);

        for (int i = 0; i <= names.length-1; i++) {
            String name = names[i];
            printer.accept(name);
        }



}
}
