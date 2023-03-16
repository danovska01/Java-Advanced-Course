package _10_FunctionalProgramming_Ex;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class _08_CustomComparator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a custom comparator that sorts all even numbers before all odd ones in ascending order.
        // Pass it to an Arrays.sort() function and print the result.
        List<Integer > numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        numbers.sort((a, b) -> {
            if (a % 2 == 0 && b % 2 == 0) {
                // both numbers are even, use natural order
                return a.compareTo(b);
            } else if (a % 2 != 0 && b % 2 != 0) {
                // both numbers are odd, use natural order
                return a.compareTo(b);
            } else if (a % 2 == 0 && b % 2 != 0) {
                // a is even and b is odd, a comes before b
                return -1;
            } else {
                // a is odd and b is even, b comes before a
                return 1;
            }
        });

        Consumer<List<Integer>> printer = list -> {
            for (int num : list) {
                System.out.print(num + " ");
            }
        };
        printer.accept(numbers);
    }
}


