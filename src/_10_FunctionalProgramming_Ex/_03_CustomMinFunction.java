package _10_FunctionalProgramming_Ex;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _03_CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a simple program that reads a set of numbers from the console and finds the smallest of the numbers using a simple Function<Integer[], Integer>.

        List<Integer>numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> getMinNumber = list-> Collections.min(list);
        System.out.println(getMinNumber.apply(numbers));

    }
}
