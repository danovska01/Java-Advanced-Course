package _09_FunctionalProgramming;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class _05_FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Write a program that reads an integer N on the first line. And on next N lines read pairs of "{name}, {age}". Then read three more lines with:
        //    • Condition - "younger" or "older"
        //    • Age - Integer
        //    • Format - "name", "age" or "name age"
        //Depending on the condition, print the pairs in the right format.

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> people = new LinkedHashMap<>();
        for (int i = 0; i <n ; i++) {
            String [] line = scanner.nextLine().split(", ");
            String name = line[0];
            int age = Integer.parseInt(line[1]);
            people.put(name, age);

        }
        String condition = scanner.nextLine();
        int age = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();

        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String, Integer>> printer =
                createPrinter(format);
        printFilteredStudent(people, tester, printer);

    }

   static void printFilteredStudent(Map<String, Integer> people, Predicate<Integer> tester, Consumer<Map.Entry<String, Integer>> printer) {

           for (Map.Entry<String, Integer> person : people.entrySet()) {
               if (tester.test(people.get(person.getKey())))
                   printer.accept(person);
           }
    }

    static Consumer<Map.Entry<String, Integer>> createPrinter(String format) {
       Consumer<Map.Entry<String, Integer>> printer = null;
       switch (format) {
           case "name age":
               printer = person -> System.out.printf("%s - %d%n",
                       person.getKey(), person.getValue());
               break;
           case "age":
               printer = person -> System.out.printf("%d%n",
                       person.getValue());
               break;
           case "name":
               printer = person -> System.out.printf("%s%n",
                       person.getKey());
               break;
       }
       return printer;

    }

    static Predicate<Integer> createTester(String condition, Integer age) {
        {
            Predicate<Integer> tester = null;
            switch (condition) {
                case "younger":
                    tester = x -> x <= age;
                    break;
                case "older":
                    tester = x -> x >= age;
                    break;
            }
            return tester;
    }
    }
}
