package _09_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02_SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //Write a program that reads one line of Integers separated by ", ". Print the count of the numbers and their sum.
        //Use a Function<String, Integer>.
        String [] stringNumbers = scanner.nextLine().split(", ");
        Function <String, Integer> integerParser = e ->Integer.parseInt(e);


        int sum = Arrays.stream(stringNumbers)
                .map(integerParser).mapToInt(Integer::intValue).sum();
        //collect(Collectors.summingInt(Integer::intValue));


        System.out.println("Count = " + stringNumbers.length);
        System.out.println("Sum = " + sum);


    }
}
