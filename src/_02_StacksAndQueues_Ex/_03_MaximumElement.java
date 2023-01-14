package _02_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class _03_MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int commandsNum = Integer.parseInt(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>(), maxStack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();

        int maxNumber = 0;

        for (int i = 0; i < commandsNum; i++) {
            String[] input = scanner.nextLine().split(" ");

            if (input[0].equals("1")) {
                int value = Integer.valueOf(input[1]);
                if (maxNumber <= value) {
                    maxNumber = value;
                    maxStack.push(maxNumber);
                }
                stack.push(value);
            } else if (input[0].equals("2")) {
                if (stack.pop() == maxNumber) {
                    maxStack.pop();
                    if (maxStack.size() > 0) {
                        maxNumber = maxStack.peek();
                    } else {
                        maxNumber = 0;
                    }
                }
            } else {
                sb.append(maxNumber).append(System.lineSeparator());
            }
        }
        System.out.println(sb);
    }
}