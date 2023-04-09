package _16_Generics_Ex._1_GenericBox;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            System.out.printf("%s%n", new Box<>(scanner.nextLine().toString()));

        }
    }
}
