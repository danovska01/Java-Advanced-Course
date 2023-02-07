package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _10_PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //On each input line, you’ll be given data in the format: "city|country|population".
        Map <String, Map<String, Long>> countriesLog = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")){
            String [] tokens = input.split("\\|");
            String city= tokens[0];
            String country= tokens[1];
            long population = Long.parseLong(tokens[2]);

            if(!countriesLog.containsKey(country)){
                Map<String, Long> citiesLog = new LinkedHashMap<>();
                citiesLog.put(city, population);
                countriesLog.put(country, citiesLog);
            }
            else {
                Map<String, Long> currentCitiesLog= countriesLog.get(country);
                currentCitiesLog.putIfAbsent(city, population);
                countriesLog.put(country, currentCitiesLog);
            }
            input=scanner.nextLine();
        }
        //Countries should be ordered by their total population in descending order and within each country,
        // the cities should be ordered by the same criterion.
        // If two countries/cities have the same population, keep them in the order in which they were entered.

        // INPUT:
        //Sofia|Bulgaria|1
        //Veliko Tarnovo|Bulgaria|2
        //London|UK|4
        //Rome|Italy|3
        //report

        //OUTPUT:
        //UK (total population: 4)
        //=>London: 4
        //Bulgaria (total population: 3)
        //=>Veliko Tarnovo: 2
        //=>Sofia: 1
        //Italy (total population: 3)
        //=>Rome: 3

        countriesLog.entrySet()
                .stream()
                .sorted((c1, c2) -> Long.compare(c2.getValue() //Countries should be ordered by their total population in descending order, so we sum all cities population
                                .values()
                                .stream()
                                .mapToLong(Long::longValue)
                                .sum(),
                        c1.getValue()
                                .values()
                                .stream()
                                .mapToLong(Long::longValue)
                                .sum()))
                .forEach(c -> {
                    System.out.printf("%s (total population: %d)%n",
                            c.getKey(),
                            c.getValue()
                                    .values()
                                    .stream()
                                    .mapToLong(Long::longValue)
                                    .sum());

                    c.getValue()
                            .entrySet()
                            .stream()
                            .sorted((t1, t2) -> Long.compare(t2.getValue(), t1.getValue())) //the cities should be ordered by the same criterion
                            .forEach(t -> System.out.printf("=>%s: %d%n", t.getKey(), t.getValue()));
                });

    }
}
