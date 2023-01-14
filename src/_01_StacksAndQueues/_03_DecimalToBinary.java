package _01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _03_DecimalToBinary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Create a simple program that can convert a decimal number to its binary representation.
        int decimal = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer>stack = new ArrayDeque<>();
        if(decimal==0){
            System.out.println(0);
        }
        else {
        while (decimal!=0){
            int leftOver = decimal%2;
            stack.push(leftOver);
            decimal=decimal/2;
        }

        for (Integer integer: stack) {
            System.out.print(integer);
        }
        }
    }
}
