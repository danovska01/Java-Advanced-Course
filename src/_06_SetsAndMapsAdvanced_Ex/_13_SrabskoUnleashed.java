package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class _13_SrabskoUnleashed {
    public static void main(String[] args) {
        // INPUT:
        //Lepa Brena @Sunny Beach 25 3500
        //Dragana @Sunny Beach 23 3500
        //Ceca @Sunny Beach 28 3500
        //End

        //OUTPUT:
        //Sunny Beach
        //#  Ceca -> 98000
        //#  Lepa Brena -> 87500
        //#  Dragana -> 80500
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> concertsLog = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            Pattern musicPattern = Pattern.compile("([\\w\\s]+)\\s@([a-zA-z\\s]+)\\s(\\d+)\\s(\\d+)"); //Mile Kitic @Sunny Beach 21 3500
            Matcher musicMatcher = musicPattern.matcher(input);

            if (musicMatcher.find()) {
                String venue = musicMatcher.group(2);
                String singer = musicMatcher.group(1);
                int ticketPrice = Integer.parseInt(musicMatcher.group(3));
                int ticketCount = Integer.parseInt(musicMatcher.group(4));


                concertsLog.putIfAbsent(venue, new LinkedHashMap<>());
                concertsLog.get(venue).putIfAbsent(singer, 0);

                int earned = ticketCount * ticketPrice;
                int totalEarned = concertsLog.get(venue).get(singer) + earned;

                concertsLog.get(venue).put(singer, totalEarned);
            }

            input = scanner.nextLine();
        }

        // For each venue, print the singer and the total amount of money his/her concerts have made on a separate line.
        // Venues should be kept in the same order they were entered,
        // the singers should be sorted by how much money they have made in descending order.
        // If two singers have made the same amount of money, keep them in the order in which they were entered.
        //Keep in mind that if a line is in incorrect format, it should be skipped- SKIP THOSE: Ceca@Belgrade125 12378, Ceca @Belgrade12312 123


        concertsLog.forEach((key, value) -> {
            System.out.println(key);
            value.entrySet().stream()
                    .sorted((x1, x2) -> x2.getValue().compareTo(x1.getValue()))
                    .forEach(e -> {
                        System.out.println(String.format("#  %s -> %s", e.getKey(), e.getValue()));
                    });
        });




    }
}
