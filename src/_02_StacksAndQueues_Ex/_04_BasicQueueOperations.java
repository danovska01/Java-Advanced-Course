package _02_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _04_BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        List<Integer> listNumbers = Arrays.asList(scanner.nextLine().split(" ")).stream().map(s -> Integer.parseInt(s.trim())).collect(Collectors.toList());
        int numberOfElementsToPutInQueue = Integer.parseInt(tokens[0]);
        int numberOfElementsToDequeue = Integer.parseInt(tokens[1]);
        int elementToCheck = Integer.parseInt(tokens[2]);

        ArrayDeque<Integer> queue = new ArrayDeque<>();


        for (int i = 0; i < numberOfElementsToPutInQueue; i++) {
            queue.offer(listNumbers.get(i));
        }

        for (int i = 0; i < numberOfElementsToDequeue; i++) {
            queue.poll();
        }
        if (queue.isEmpty()) {
            System.out.println(0);
        }
        else {
            int minNum= 2000000;
            ArrayDeque<Integer>minQueue = new ArrayDeque<>();
            boolean isTrue=false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                if(queue.peek()==elementToCheck){
                    System.out.println("true");
                    isTrue=true;
                    break;
                }
                else {
                    if(queue.peek()<minNum){
                        minNum=queue.peek();
                        minQueue.offer(minNum);
                    }
                    queue.poll();
                }

            }
            if(!isTrue){
            System.out.println(minNum);
            }
        }

    }
}
