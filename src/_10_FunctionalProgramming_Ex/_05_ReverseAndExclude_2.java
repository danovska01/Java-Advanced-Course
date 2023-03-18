package _10_FunctionalProgramming_Ex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude_2 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        Collections.reverse(numbers);
        Predicate<Integer>checkIfDivision = number -> number % n ==0;
        //numbers.stream().filter(checkIfDivision);
        numbers.removeIf(checkIfDivision);
        numbers.forEach(number -> System.out.println(number+ " "));
    }
}
