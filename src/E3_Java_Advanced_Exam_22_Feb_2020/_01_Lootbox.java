package E3._Java_Advanced_Exam_22_Feb_2020;

import java.util.*;

public class _01_Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //You need to start from the first item in the first box (QUEUE) and sum it up with the last item in the second box (STACK).
        //STACK - PUSH, POP, PEEK
        //QUEUE - OFFER, POLL, PEEK



        //read FIRST Loot Box - Queue
        String[] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> firstLootBox = new ArrayDeque<>();
        for (String token: tokens){
            firstLootBox.offer(Integer.parseInt(token)); //QUEUE
        }

        //read SECOND Loot Box - STACK
        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> secondLootBox= new ArrayDeque<>();
        for (String token: tokens){
            secondLootBox.push(Integer.parseInt(token)); //STACK
        }

        List<Integer> claimedValue = new LinkedList<>();
        while (!firstLootBox.isEmpty() && !secondLootBox.isEmpty()){

            int numFromFirstBox = firstLootBox.peek();
            int numFromSecondBox= secondLootBox.peek();

            if((numFromFirstBox+numFromSecondBox)%2 == 0){
                claimedValue.add(numFromFirstBox+numFromSecondBox);
                firstLootBox.poll();
                secondLootBox.pop();
            }
            else {
                //Otherwise, remove the last item from the second box and add it to the last position in the first box.
                firstLootBox.offer(secondLootBox.pop());
            }
        }

        if(firstLootBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (secondLootBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        int sum = claimedValue.stream().mapToInt(Integer::intValue).sum();
        if(sum>=100){
            System.out.printf("Your loot was epic! Value: %d%n", sum);
        }
        else {
            System.out.printf("Your loot was poor... Value: %d%n", sum);
        }




    }
}
