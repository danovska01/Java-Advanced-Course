package _06_SetsAndMapsAdvanced_Ex;

import java.util.*;
import java.util.stream.Collectors;

public class _08_HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Set<String>> log = new LinkedHashMap<>();
        while (!input.equals("JOKER")) {
            String[] tokens = input.split(": ");
            String name = tokens[0];
            String[] cardsArr = tokens[1].split(", ");
            Set<String> cards = Arrays.stream(cardsArr).collect(Collectors.toCollection(LinkedHashSet::new));

            if (!log.containsKey(name)) {
                log.put(name, cards);
            } else {
                Set<String> cardsPossessed = log.get(name);

                while (cards.size() > 0) {
                    String card = cards.iterator().next();
                    cardsPossessed.add(card);
                    cards.remove(card);
                }
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Set<String>> entry : log.entrySet()) {
            Set<String> currentSet = entry.getValue();

            int powerValue = 0;
            int typeValue = 0;
            int totalValue=0;

            while (currentSet.size() > 0) {
                String card = currentSet.iterator().next();

                if (card.length() == 2) { // cards can be either 1-10 digit + (letter) format ot two letters format: 3H, 10S, JC, KD, 5S, 10S
                    char type = card.charAt(1); // ex. JC, KD, 5S - if length is 2, type of card is on position 1, if the length is 3- the position of type is 1
                    typeValue= checkTypeValue(type);
                    char power = card.charAt(0);

                    if (power >= 50 && power <= 57) { //ascii code from 2 to 9
                        powerValue = Character.getNumericValue(power); //its int value 2-9
                    } else { // JC, QH, JD power is letter
                        switch (power) {
                            case 'J':
                                powerValue = 11;
                                break;
                            case 'Q':
                                powerValue = 12;
                                break;
                            case 'K':
                                powerValue = 13;
                                break;
                            case 'A':
                                powerValue = 14;
                                break;
                        }
                    }
                } else if (card.length()==3){ // 10S, 10C
                    char type = card.charAt(2);
                    typeValue= checkTypeValue(type);
                    powerValue = 10; // no checks if those two symbols are different, it is said that power can only be: 2, 3, 4, 5, 6, 7, 8, 9, 10, J, Q, K, A
                }

                int currentValue = typeValue * powerValue;
                totalValue+=currentValue;
                currentSet.remove(card);

            }


            System.out.printf("%s: %d%n", entry.getKey(), totalValue);
        }

    }

    private static int checkTypeValue(char type) {
        int typeValue=0;
        switch (type){
        case 'S':
        typeValue = 4;
        break;
        case 'H':
        typeValue = 3;
        break;
        case 'D':
        typeValue = 2;
        break;
        case 'C':
        typeValue = 1;
        break;
        default:
        break;
        }

        return typeValue;
    }
}
