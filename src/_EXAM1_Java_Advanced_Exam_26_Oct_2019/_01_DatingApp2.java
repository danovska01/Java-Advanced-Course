package _EXAM1_Java_Advanced_Exam_26_Oct_2019;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _01_DatingApp2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> malesStack = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(malesStack::push);
        ArrayDeque<Integer> femalesQueues = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).forEach(femalesQueues::offer);

        int matches = 0;

        while (!malesStack.isEmpty() && !femalesQueues.isEmpty()) {
            int male = malesStack.peek();
            int female = femalesQueues.peek();

            if (male == female) {
                malesStack.pop();
                femalesQueues.poll();
                matches++;
            } else if (male <= 0) {
                malesStack.pop();
            } else if (female <= 0) {
                femalesQueues.poll();
            } else if (male % 25 == 0) {
                malesStack.pop();
                malesStack.pop();
            } else if (female % 25 == 0) {
                femalesQueues.poll();
                femalesQueues.poll();
            } else if (male != female) {
                femalesQueues.poll();
                int current = male - 2;
                malesStack.pop();
                malesStack.push(current);
            }

        }

        System.out.printf("Matches: %d%n", matches);

        if (malesStack.isEmpty()) {
            System.out.printf("Males left: none%n");
        } else {
            System.out.println("Males left: " + print(malesStack));
        }

        if (femalesQueues.isEmpty()) {
            System.out.printf("Females left: none%n");
        } else {
            System.out.println("Females left: " + print(femalesQueues));
        }


    }

    private static String print(ArrayDeque<Integer> malesOrFemales) {
        StringBuilder output = new StringBuilder();
        int size = 0;
        for (Integer integer : malesOrFemales) {
            if (size != malesOrFemales.size() - 1) {
                output.append(integer + ", ");
                size++;
            } else {
                output.append(integer);
            }
        }
        return output.toString();
    }
}
