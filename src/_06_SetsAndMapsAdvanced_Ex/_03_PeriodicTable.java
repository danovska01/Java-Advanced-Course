package _06_SetsAndMapsAdvanced_Ex;

import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class _03_PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 1; i <=n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j <= input.length-1 ; j++) {
                String currentElement = input[j];
                elements.add(currentElement);
            }
        }
        elements.retainAll(elements);
        elements.forEach(u -> System.out.print(u + " "));

    }
}
