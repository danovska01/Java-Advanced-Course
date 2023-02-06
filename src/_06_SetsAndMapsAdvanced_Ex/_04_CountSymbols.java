package _06_SetsAndMapsAdvanced_Ex;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _04_CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that reads some text from the console and counts the occurrences of each character in it.
        // Print the results in alphabetical (lexicographical) order.
        Map<Character, Integer> characters = new TreeMap<>();
        String text = scanner.nextLine();
        for (int i = 0; i <= text.length()-1 ; i++) {
            char currentSymbol= text.charAt(i);
            if(!characters.containsKey(currentSymbol)){
                characters.put(currentSymbol, 1);
            }
            else {
                int index= characters.get(currentSymbol);
                index++;
                characters.put(currentSymbol, index);
            }
        }
     for(Character currentChar: characters.keySet()){
         System.out.printf("%c: %d time/s%n", currentChar, characters.get(currentChar));
     }
    }
}
