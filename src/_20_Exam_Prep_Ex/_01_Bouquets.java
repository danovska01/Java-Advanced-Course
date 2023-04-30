package _20_Exam_Prep_Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _01_Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] information1 = scanner.nextLine().split(", ");
        String[] information2 = scanner.nextLine().split(", ");


        ArrayDeque<Integer> tulips = new ArrayDeque<>(); //stack
        ArrayDeque<Integer> daffodils = new ArrayDeque<>(); //queue

        int countBouquets = 0;
        int tulipsLeft = 0;
        int daffodilsLeft = 0;

        for (int i = 0; i < information1.length; i++) {
            int number = Integer.parseInt(information1[i]);
            tulips.push(number);
        }
        for (int i = 0; i < information2.length; i++) {
            int number = Integer.parseInt(information2[i]);
            daffodils.offer(number);
        }
        while (tulips.size() > 0 && daffodils.size() > 0) {
            int currentTulips = tulips.pop();
            int currentDaffodils = daffodils.poll();

            if (currentTulips + currentDaffodils == 15) {//. If the sum of their values is equal to 15 – create one bouquet and remove them
                countBouquets++;
            } else if (currentTulips + currentDaffodils > 15) {
                while (currentTulips + currentDaffodils > 15) {// While the sum is bigger than 15, keep decreasing the value of the tulips by 2
                    currentTulips -= 2;
                    //tulipsLeft+=2;
                }
                if (currentTulips + currentDaffodils == 15) {
                    countBouquets++;
                } else {
                    tulipsLeft += currentTulips;
                    daffodilsLeft += currentDaffodils;
                }

            } else {// If the sum is less than 15 you have to store them for later and remove them
                tulipsLeft += currentTulips;
                daffodilsLeft += currentDaffodils;
            }
        }


        if (tulipsLeft + daffodilsLeft >= 15) {
            int totalLeft = tulipsLeft + daffodilsLeft;
            int countFromLeft = totalLeft / 15;
            countBouquets += countFromLeft;
        }

        if (countBouquets >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!%n", countBouquets);
        } else {
            System.out.printf("You failed... You need more %d bouquets.%n", 5 - countBouquets);
        }
    }
}
