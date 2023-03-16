package _10_FunctionalProgramming_Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _06_PredicateForNames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a predicate. Its goal is to check a name for its length and to return true if the length of the name is less or equal to the passed integer.
        // You will be given an integer that represents the length you have to use. On the second line, you will be given a string array with some names.
        // Print the names, passing the condition in the predicate.
        int length = Integer.parseInt(scanner.nextLine());
        List<String >names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());


        Predicate<String>testNameLength = name -> {
            if (name.length()>length){
            return false;
            }
            return true;
        };

        for (int i = 0; i < names.size(); i++) {
            String name = names.get(i);

            if(testNameLength.test(name)){
                System.out.println(name);
            }



        }
    }
}
