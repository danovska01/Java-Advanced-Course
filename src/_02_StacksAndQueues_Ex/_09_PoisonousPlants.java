package _02_StacksAndQueues_Ex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class _09_PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] plants = scanner.nextLine().split(" ");

        ArrayDeque<Integer> indexes = new ArrayDeque<>();
        indexes.push(0);

        int[] days = new int[n];

        for (int i = 0; i < n; i++) {

            int maxDays = 0;

            while (indexes.size() > 0 && Integer.valueOf(plants[indexes.peek()]) >= Integer.valueOf(plants[i])) {
                maxDays = Math.max(maxDays, days[indexes.pop()]);
            }

            if (indexes.size() > 0) {
                days[i] = maxDays + 1;
            }

            indexes.push(i);
        }
        System.out.println(max(days));
    }

    private static int max(int[] days) {
        int max = Integer.MIN_VALUE;
        for (int day : days) {
            if (day > max) {
                max = day;
            }
        }
        return max;
    }



}
