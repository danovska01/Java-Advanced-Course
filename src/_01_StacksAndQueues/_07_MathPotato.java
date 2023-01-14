package _01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _07_MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1).
        //If a cycle is prime, just print the child's name.

        String [] children= scanner.nextLine().split(" ");
        int numberOfTurns= Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> childrenQueue= new ArrayDeque<>();


        for (String child : children) {
            childrenQueue.offer(child);
        }
       // А child is removed only on a composite (not prime) cycle (cycles start from 1).
        int cycle = 1;
        while(childrenQueue.size() != 1){
            for (int i = 1; i < numberOfTurns; i++) {
                String currentChild = childrenQueue.poll();
                if (currentChild != null) {
                    childrenQueue.offer(currentChild);
                }
            }

            if (isPrime(cycle)) {
                System.out.println("Prime " + childrenQueue.peek());
            } else {
                System.out.println("Removed " + childrenQueue.pop());
            }
            cycle++;
        }
        String lastChild = childrenQueue.peek();
        System.out.printf("Last is %s", lastChild);
    }

    static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        else if (n == 2)
            return true;
        else if (n % 2 == 0)
            return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;

    }

}
