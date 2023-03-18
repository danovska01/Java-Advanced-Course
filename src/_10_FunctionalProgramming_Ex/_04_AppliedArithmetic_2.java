package _10_FunctionalProgramming_Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _04_AppliedArithmetic_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String command = scanner.nextLine();
        Function<List<Integer>, List<Integer>> add = list -> list.stream().map(number -> number+=1).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> multiply = list -> list.stream().map(number -> number*=2).collect(Collectors.toList());
        Function<List<Integer>, List<Integer>> subtract = list -> list.stream().map(number -> number-=1).collect(Collectors.toList());
        Consumer<List<Integer>> print = list -> list.forEach(number -> System.out.println(number+ " "));

        while (!command.equals("end")){
            switch (command) {
                case "add":
                    numbers=add.apply(numbers);
                     break;
                case "multiply":
                    numbers=multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers= subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    break;

            }

            command= scanner.nextLine();
        }
    }
}
