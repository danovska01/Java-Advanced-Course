package E2_Java_Advanced_Exam_23_October_2021;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class _01_AutumnCocktails {
    private static final int PEAR_SOUR= 150;
    private static final int THE_HARVEST= 250;
    private static final int APPLE_HINNY= 300;
    private static final int HIGH_FASHION= 400;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> cocktails = new HashMap<>();
        cocktails.put("Pear Sour", 0);
        cocktails.put("The Harvest", 0);
        cocktails.put("Apple Hinny", 0);
        cocktails.put("High Fashion", 0);


        //read ingredients
        String [] tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        for (String token: tokens){
            ingredients.offer(Integer.parseInt(token)); //queue
        }

        //read freshness
        tokens = scanner.nextLine().split("\\s+");
        ArrayDeque<Integer> freshness = new ArrayDeque<>();
        for (String token: tokens){
            freshness.push(Integer.parseInt(token)); //stack
        }

        while (!ingredients.isEmpty() && !freshness.isEmpty()){

        Integer firstIngredient = ingredients.poll();
        if(firstIngredient==0){
            continue;
        }
        Integer lastIngredient = freshness.pop();

        int totalLevel= firstIngredient*lastIngredient;
        switch (totalLevel){
            case PEAR_SOUR:
                int pearSourCounter= cocktails.get("Pear Sour");
                pearSourCounter++;
                cocktails.put("Pear Sour", pearSourCounter);
                break;
            case THE_HARVEST:
                int theHarvestCounter= cocktails.get("The Harvest");
                theHarvestCounter++;
                cocktails.put("The Harvest", theHarvestCounter);
                break;
            case APPLE_HINNY:
                int appleHinnyCounter= cocktails.get("Apple Hinny");
                appleHinnyCounter++;
                cocktails.put("Apple Hinny", appleHinnyCounter);
                break;
            case HIGH_FASHION:
                int highFashionCounter= cocktails.get("High Fashion");
                highFashionCounter++;
                cocktails.put("High Fashion", highFashionCounter);
                break;
            default:
                firstIngredient+=5;
                ingredients.offer(firstIngredient);
                break;
        }

        }
        if(cocktails.get("Pear Sour")>0 && cocktails.get("The Harvest")> 0 && cocktails.get("Apple Hinny")>0 && cocktails.get("High Fashion")>0){
            System.out.println("It's party time! The cocktails are ready!");
        }
        else {
            System.out.println("What a pity! You didn't manage to prepare all cocktails.");
        }
        if (!ingredients.isEmpty()){
            int leftOverIngredients = ingredients.stream().mapToInt(e->e).sum();
            System.out.printf("Ingredients left: %d%n", leftOverIngredients);
        }
        //и така нареждаме ръчно по азбучен ред в тоя формат всичките 4.........
        //другият вариант е да са в treemap, той сортира по ключ
        /*if (cocktails.get("Apple Hinny")>0){
            System.out.printf("# Apple Hinny --> %d%n", cocktails.get("Apple Hinny"));
        }*/

        cocktails.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> {
                    if (entry.getValue() > 0) {
                        System.out.println("# " + entry.getKey() + " --> " + entry.getValue());
                    }
                });


    }
}
