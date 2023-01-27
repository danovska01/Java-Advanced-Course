package _05_SetsAndMapsAdvanced;

import java.util.*;
import java.util.stream.Collectors;

public class _03_Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstPlayerInput = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LinkedHashSet<Integer> firstPlayer = new LinkedHashSet<>(firstPlayerInput);

        List<Integer> secondPlayerInput = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        LinkedHashSet<Integer> secondPlayer = new LinkedHashSet<>(secondPlayerInput);


        for (int i = 0; i < 50; i++) {
            if(secondPlayer.isEmpty()){
                System.out.println("First player win!");
                return;
            }
            else if (firstPlayer.isEmpty()){
                System.out.println("Second player win!");
                return;
            }
            Integer firstPlayerCard = getTopValue(firstPlayer);
            Integer secondPlayerCard = getTopValue(secondPlayer);

            firstPlayer.remove(firstPlayerCard);
            secondPlayer.remove(secondPlayerCard);
            if(firstPlayerCard>secondPlayerCard){
            firstPlayer.add(firstPlayerCard);
            firstPlayer.add(secondPlayerCard);
            }
            else if (secondPlayerCard>firstPlayerCard) {
                secondPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }
            else {
                firstPlayer.add(firstPlayerCard);
                secondPlayer.add(secondPlayerCard);
            }



        }
        int firstPlayerLeftCards= firstPlayer.size();
        int secondPlayerLeftCards= secondPlayer.size();

        if(firstPlayerLeftCards>secondPlayerLeftCards){
            System.out.println("First player win!");
        }
        else if (secondPlayerLeftCards>firstPlayerLeftCards){
            System.out.println("Second player win!");
        }
         else {
            System.out.println("Draw!");
        }


    }
    private static Integer getTopValue(LinkedHashSet<Integer> set) {
        for (Integer integer : set) {
            return integer;
        }
        return 0;
    }
}
