package _01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _06_HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] childrenNames= scanner.nextLine().split(" ");
        int numberOfTosses= Integer.parseInt(scanner.nextLine());
        ArrayDeque<String>children= new ArrayDeque<>();


        for (int i = 0; i < childrenNames.length; i++) {
            String currentChild= childrenNames[i];
            children.offer(currentChild);
        }

        while (children.size()>1){
            for (int i = 1; i < numberOfTosses; i++) {
                //Every nth toss the child left with the potato leaves the game.
                String childToMove= children.poll();
                children.offer(childToMove);
            }
            String childToRemove= children.poll();
            System.out.println("Removed "+ childToRemove);

        }
        System.out.println("Last is "+ children.poll());

    }
}
