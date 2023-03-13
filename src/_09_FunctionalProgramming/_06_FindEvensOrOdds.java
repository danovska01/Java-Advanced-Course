package _09_FunctionalProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class _06_FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //You are given a lower and an upper bound for a range of integer numbers.
        // Then a command specifies if you need to list all even or odd numbers in the given range.
        // Use predicates that need to be passed to a method.

        String [] numbers = scanner.nextLine().split(" ");
        int lowerBoundNumber = Integer.parseInt(numbers[0]);
        int upperBoundNumber = Integer.parseInt(numbers[1]);
        List<Integer> numbersList = new ArrayList<>();
        for (int i = lowerBoundNumber; i <=upperBoundNumber ; i++) {
            numbersList.add(i);
        }
        String command = scanner.nextLine();

        Predicate<Integer> tester = createTester(numbersList, command);
        printFilteredNumbers(tester, numbersList);
    }

   static void printFilteredNumbers(Predicate<Integer> tester, List<Integer> numbersList) {
       for (int num: numbersList) {
           if (tester.test(num))
               System.out.print(num+ " ");
       }
    }

    static Predicate<Integer> createTester(List<Integer> numbersList, String command) {
         Predicate<Integer> tester = null;
         switch (command) {
             case "even":
                 tester = x -> x%2==0;
                 break;
             case "odd":
                 tester = x -> x%2!=0;
                 break;
         }
         return tester;
    }
}
