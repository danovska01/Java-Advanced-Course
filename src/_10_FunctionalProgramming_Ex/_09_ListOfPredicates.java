package _10_FunctionalProgramming_Ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _09_ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Find all numbers in the range 1..N that is divisible by the numbers of a given sequence. Use predicates.

        int n = Integer.parseInt(scanner.nextLine());
        List<Integer > numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> divisibleNumbers = getDivisibleNumbers(n, numbers);
        divisibleNumbers.stream().forEach(num -> System.out.print(num+ " "));

    }

    private static List<Integer> getDivisibleNumbers(int n, List<Integer> numbers) {
        List<Integer> divisibleNumbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            boolean isDivisible = true;
            for (Integer num : numbers) {
                Predicate<Integer> isDivisibleByNum = x -> x % num == 0;
                if (!isDivisibleByNum.test(i)) {
                    isDivisible = false;
                    break;
                }
            }
            if (isDivisible) {
                divisibleNumbers.add(i);
            }
        }
        return divisibleNumbers;
    }


}
