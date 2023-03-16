package _10_FunctionalProgramming_Ex;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // On the first line, you are given a list of numbers.
        // On the next lines you are passed different commands that you need to apply to all numbers in the list:
        // "add" -> adds 1;
        // "multiply" -> multiplies by 2;
        // "subtract" -> subtracts 1;
        // "print" -> prints all numbers on a new line.
        // The input will end with an "end" command, after which the result must be printed.

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        List<Integer> mutableNumbers = new ArrayList<>(numbers);

        String command = scanner.nextLine();
        System.out.println();
        while (!command.equals("end")) {
            switch (command) {
                case "add":

                    Function<List<Integer>, List<Integer>> add1 = list -> {
                        list.replaceAll(integer -> integer + 1);
                        return list;
                    };
                    add1.apply(mutableNumbers);
                    break;
                case "multiply":
                    Function<List<Integer>, List<Integer>> multiply = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) * 2);
                        }
                        return list;
                    };
                    multiply.apply(mutableNumbers);
                    break;
                case "subtract":
                    Function<List<Integer>, List<Integer>> subtract = list -> {
                        for (int i = 0; i < list.size(); i++) {
                            list.set(i, list.get(i) - 1);
                        }
                        return list;
                    };
                    subtract.apply(mutableNumbers);
                    break;
                case "print":
                    Consumer<List<Integer>> printer = list -> {
                        for (int num : list) {
                            System.out.print(num+ " ");
                        }
                    };
                    printer.accept(mutableNumbers);

                    break;
            }

            command = scanner.nextLine();
        }
    }
}
