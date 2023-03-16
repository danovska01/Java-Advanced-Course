package _10_FunctionalProgramming_Ex;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _03_CustomMinFunction_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).toList();
        Consumer<List<Integer>> printMinNumber = list-> System.out.println(Collections.min(list));
        printMinNumber.accept(numbers);

    }
}
