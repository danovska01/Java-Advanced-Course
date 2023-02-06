package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _06_AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer>resources = new LinkedHashMap<>();
        while (!input.equals("stop")){
            String resource = input;
            int quantity=Integer.parseInt(scanner.nextLine());
            if(!resources.containsKey(resource)){
                resources.put(resource, quantity);
            }
            else {
            int quantityPresented= resources.get(resource);
            int newQuantity= quantityPresented+quantity;
            resources.put(resource, newQuantity);
            }

            input=scanner.nextLine();
        }
        for(Map.Entry<String, Integer>entry:resources.entrySet()){
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
