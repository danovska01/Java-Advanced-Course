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
            int quantity=Integer.parseInt(input);
            if(!resources.containsKey(resource)){
                resources.put(resource, quantity);
            }
            else {

            }

            input=scanner.nextLine();
        }
    }
}
