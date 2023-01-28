package _05_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _04_CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double [] values = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToDouble(Double::parseDouble)
                .toArray();
        Map<Double, Integer>valuesWithOccurences = new LinkedHashMap<>();

        for(double value: values){
            if(!valuesWithOccurences.containsKey(value)){
                valuesWithOccurences.put(value, 1);
            }
            else {
                valuesWithOccurences.put(value, valuesWithOccurences.get(value)+1);
            }
        }
        for(Double key : valuesWithOccurences.keySet()){
            System.out.println(String.format("%.1f -> %d", key, valuesWithOccurences.get(key)));
        }
    }
}
