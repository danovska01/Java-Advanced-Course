package _02_StacksAndQueues_Ex;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class _02_BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        List<Integer> listNumbers = Arrays.asList(scanner.nextLine().split(" ")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        int numberOfElementsToPushIntoTheStack = Integer.parseInt(tokens[0]);
        int numberOfElementsToPopFromTheStack = Integer.parseInt(tokens[1]);
        int elementToCheck = Integer.parseInt(tokens[2]);


        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int minNumber = Integer.MAX_VALUE;
        boolean isTrue = true;

        for (int i = 0; i < numberOfElementsToPushIntoTheStack; i++) {
            stack.push(listNumbers.get(i));
        }

        for (int i = 0; i < numberOfElementsToPopFromTheStack; i++) {
            stack.pop();
        }
        if (stack.isEmpty()) {
            System.out.println(0);
        } else {
            int size = stack.size();
            List<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int number = stack.pop();
                numbers.add(number);
                if (number == elementToCheck) {
                    System.out.println("true");
                    isTrue = false;
                    break;

                }
            }
            if (isTrue) {
                for (int j = 0; j < numbers.size(); j++) {
                    int number = numbers.get(j);
                    if (number < minNumber) {
                        minNumber = number;
                    }
                }
                System.out.println(minNumber);
            }


        }


    }
}
