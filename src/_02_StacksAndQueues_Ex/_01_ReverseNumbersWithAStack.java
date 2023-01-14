package _02_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_ReverseNumbersWithAStack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = Arrays.asList(scanner.nextLine().split(" ")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        ArrayDeque<Integer>stack= new ArrayDeque<>();

        for (int i = 0; i < list.size(); i++) {
            int currentNumber = list.get(i);
            stack.push(currentNumber);
        }
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            System.out.print(stack.pop()+ " ");
        }

    }
}
