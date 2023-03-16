package _10_FunctionalProgramming_Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _07_FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program which is using a custom function (written by you) to find the smallest integer in a sequence of integers.
        // The input could have more than one space. Your task is to collect the integers from the console,
        // find the smallest one and print its index (if more than one such elements exist, print the index of the rightmost one).

        List<Integer>numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        Function<List<Integer>, Integer> findMinNumber = list ->{
            int minNum = 10000000;
            int index = 0;
            for (int i = list.size()-1; i >= 0; i--) {
             int num = list.get(i);
             if(num<minNum){
                 minNum=num;
                 index=i;
             }
            }
            return index;
        };

        Consumer<Integer> printer = n -> System.out.println(n);

        int minNum = findMinNumber.apply(numbers);
        printer.accept(minNum);
    }
}
