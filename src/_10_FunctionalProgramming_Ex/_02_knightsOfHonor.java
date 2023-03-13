package _10_FunctionalProgramming_Ex;

import java.util.Scanner;
import java.util.function.Consumer;

public class _02_knightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that reads a collection of names as strings from the console and then appends "Sir"
        // in front of every name and prints it back onto the console. Use a Consumer<T>.

        String [] names = scanner.nextLine().split("\\s+");
        Consumer<String> printer = e -> System.out.println("Sir "+ e);

        for (int i = 0; i <= names.length-1; i++) {
            String name = names[i];
            printer.accept(name);
    }
}
}
