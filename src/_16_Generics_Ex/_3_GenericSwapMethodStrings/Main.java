package _16_Generics_Ex._3_GenericSwapMethodStrings;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Create a generic method that receives a list containing any type of data and swaps the elements at two given indexes.

        int n = Integer.parseInt(scanner.nextLine());
        Box box = new Box<>();

        for (int i = 0; i < n; i++) {
            box.getCollection().add(scanner.nextLine());
        }
        int[] indexes = Arrays.stream(scanner.nextLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box.swapper(box.getCollection(), indexes[0], indexes[1]);
        System.out.println(box.toString());
    }

    }

