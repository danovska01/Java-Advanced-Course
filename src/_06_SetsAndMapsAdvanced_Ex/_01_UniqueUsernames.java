package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<String> set = new LinkedHashSet<>();
        for (int i = 1; i <= n; i++) {
            String newWord = scanner.nextLine();
            set.add(newWord);
        }
        for (String current : set) {
            System.out.println(current);
        }


    }
}
