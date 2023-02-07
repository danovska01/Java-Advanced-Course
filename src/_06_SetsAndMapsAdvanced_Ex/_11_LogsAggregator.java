package _06_SetsAndMapsAdvanced_Ex;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _11_LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> users = new TreeMap<>();
        for (int i = 1; i <=n ; i++) {
            String [] input = scanner.nextLine().split("\\s+");
            String ip = input[0];
            String name = input[1];
            int duration = Integer.parseInt(input[2]);
            if(!users.containsKey(name)){
                Map<String, Integer> ips = new TreeMap<>();
                ips.put(ip, duration);
                users.put(name, ips);
            }
            else {
                Map<String, Integer> ips =users.get(name);
                if(!ips.containsKey(ip)){
                    ips.put(ip, duration);
                }
                else{
                    int currentDuration = ips.get(ip);
                    ips.put(ip, duration+currentDuration);
                }
                users.put(name, ips);
            }


        }
        // Print one line for each user (order users alphabetically).
        // For each user print its sum of durations and all of his sessions' IPs, ordered alphabetically in format "{user}: {duration} [{IP1}, {IP2}, ...]".
        // Remove any duplicated values in the IP addresses and order them alphabetically (like we order strings).

        // INPUT:
        //7
        //192.168.0.11 peter 33
        //10.10.17.33 alex 12
        //10.10.17.35 peter 30
        //10.10.17.34 peter 120
        //10.10.17.34 peter 120
        //212.50.118.81 alex 46
        //212.50.118.81 alex 4

        //OUTPUT:
        //alex: 62 [10.10.17.33, 212.50.118.81]
        //peter: 303 [10.10.17.34, 10.10.17.35, 192.168.0.11]

        users.entrySet()
                .stream()
                .sorted((u1, u2) -> u1.getKey().compareTo(u2.getKey())) //order the users alphabetically
                .forEach(u -> {
                    int totalDuration = u.getValue()
                            .values()
                            .stream()
                            .mapToInt(Integer::intValue)
                            .sum(); //get sum all of ip addresses

                    String[] ips = u.getValue()
                            .keySet()
                            .stream()
                            .sorted()
                            .toArray(String[]::new); //get only ip addresses and sort them alphabetically

                    System.out.printf("%s: %d [%s]%n",
                            u.getKey(),
                            totalDuration,
                            String.join(", ", ips));
                });

    }
}
