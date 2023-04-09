package _16_Generics_Ex._6_GenericCountMethodDoubles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Box<Double> box = new Box<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            box.getCollection().add(Double.parseDouble(scanner.nextLine()));
        }

        double element = Double.parseDouble(scanner.nextLine());

        int count = Box.compare(box.getCollection(), element);

        System.out.println(count);
    }
}