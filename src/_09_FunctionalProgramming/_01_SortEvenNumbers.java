package _09_FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] stringNumbers = scanner.nextLine().split(", ");

        List<String>numbers = Arrays.stream(stringNumbers)
                .map(e ->Integer.parseInt(e))
                .filter(e->e%2==0)
                .map(e->e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", numbers));

        List<String>evenNumbers = Arrays.stream(stringNumbers)
                .map(e ->Integer.parseInt(e))
                .sorted()
                .filter(e->e%2==0)
                .map(e->e.toString())
                .collect(Collectors.toList());

        System.out.println(String.join(", ", evenNumbers));
    }
}
