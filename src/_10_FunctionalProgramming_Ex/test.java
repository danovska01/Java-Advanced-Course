package _10_FunctionalProgramming_Ex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // add" -> adds 1
        // create a mutable list from the immutable list returned by toList(), or use a mutable list from the start.

        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> mutableNumbers = new ArrayList<>(numbers);

        /*List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split("\\s+"))
                                              .map(Integer::parseInt)
                                              .collect(Collectors.toList()));*/


        Function<List<Integer>, Void> add1 = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) + 1);
            }
            return null;
        };
        add1.apply(mutableNumbers);
        System.out.println(mutableNumbers);


        //-----------------------------------------------------------------------------------------------------------------------------------


    }
}
