package _16_Generics_Ex._4_GenericSwapMethodIntegers;

import _16_Generics_Ex._3_GenericSwapMethodStrings.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());

        Box<Integer> box = new Box<>();

        for (int i = 0; i < n; i++) {
            box.getCollection().add(Integer.parseInt(reader.readLine()));
        }
        int[] indexes = Arrays.stream(reader.readLine()
                        .split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        Box.swapper(box.getCollection(), indexes[0], indexes[1]);
        System.out.println(box.toString());
    }

}


