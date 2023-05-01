package E1_Java_Advanced_Exam_26_Oct_2019;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _01_DatingApp {
    public static void main(String[] args) {
        //first female= queue
        // match it with the last male= stack

        //STACK - PUSH, POP, PEEK
        //QUEUE - OFFER, POLL, PEEK

        Scanner scanner = new Scanner(System.in);

        String[] tokensMales = scanner.nextLine().split("\\s+");
        String[] tokensFemales = scanner.nextLine().split("\\s+");

        ArrayDeque<Integer> males = new ArrayDeque<>();
        for (String male : tokensMales) {
            males.push(Integer.parseInt(male)); //stack
        }

        ArrayDeque<Integer> feMales = new ArrayDeque<>();
        for (String female : tokensFemales) {
            feMales.offer(Integer.parseInt(female)); //queue
        }
        int matches = 0;

        while (!males.isEmpty() && !feMales.isEmpty()) {

            int male = males.peek();
            int female = feMales.peek();

            //If someone’s value is equal to or below 0, you should remove him/her before trying to match
            if (male <= 0) {
                males.pop();
                continue;
            }
            if (female <= 0) {
                feMales.pop();
                continue;
            }


            //if someone’s value divisible by 25 without remainder, you should remove him/her and the next person of the same gender.
            if (male % 25 == 0) {
                males.pop();
                males.pop();
                continue;
            }
            if (female % 25 == 0) {
                feMales.pop();
                feMales.pop();
                continue;
            }


            if (male == female) { //If their values are equal, you have to match them and remove both of them.
                males.pop();
                feMales.poll();
                matches++;
            } else {
                males.pop();
                feMales.poll();
                male -= 2;
                males.push(male); //decrease the value of the male by 2

            }
        }

        System.out.printf("Matches: %d%n", matches);
        if (males.isEmpty()) {
            System.out.println("Males left: none");
        } else {
            System.out.print("Males left: ");
            System.out.println(males.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

        if (feMales.isEmpty()) {
            System.out.println("Females left: none");
        } else {
            System.out.print("Females left: ");
            System.out.println(feMales.stream().map(String::valueOf).collect(Collectors.joining(", ")));
        }

    }
}
