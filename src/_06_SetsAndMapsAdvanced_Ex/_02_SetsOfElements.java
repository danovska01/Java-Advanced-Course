package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class _02_SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] numbers = scanner.nextLine().split("\\s+");
        int n1= Integer.parseInt(numbers[0]);
        int n2= Integer.parseInt(numbers[1]);
        Set<Integer> set1= new LinkedHashSet<>();
        Set<Integer> set2= new LinkedHashSet<>();

        for (int i = 1; i <= n1 ; i++) {
            int number= Integer.parseInt(scanner.nextLine());
            set1.add(number);
        }
        for (int i = 1; i <= n2 ; i++) {
            int number= Integer.parseInt(scanner.nextLine());
            set2.add(number);
        }
        set1.retainAll(set2);
        set1.forEach(u -> System.out.print(u + " "));




    }
}
