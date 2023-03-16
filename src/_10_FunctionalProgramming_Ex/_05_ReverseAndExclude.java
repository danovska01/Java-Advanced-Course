package _10_FunctionalProgramming_Ex;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _05_ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that reverses a collection and removes elements that are divisible by a given integer n.

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        List<Integer> mutableNumbers = new ArrayList<>(numbers);


        int n = Integer.parseInt(scanner.nextLine());
        Function<List<Integer>, List<Integer>> exclude = list -> {

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) % n == 0) {
                    list.remove(i);
                    i--;
                }
            }
            return list;
        };
        exclude.apply(mutableNumbers);

        Function<List<Integer>, List<Integer>> reverseList = list -> {
            Collections.reverse(list);
            return list;
        };
        reverseList.apply(mutableNumbers);

        Consumer<List<Integer>> printer = list -> {
            for (int num : list) {
                System.out.print(num + " ");
            }
        };
        printer.accept(mutableNumbers);


    }


}
