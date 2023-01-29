package _05_SetsAndMapsAdvanced;

import java.util.*;

public class _07_CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        Map<String, LinkedHashMap<String, List<String>>> continents = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String continent = tokens[0];
            String country = tokens[1];
            String city = tokens[2];


            if (continents.containsKey(continent)) {
                LinkedHashMap<String, List<String>> countries = continents.get(continent);


                if (countries.containsKey(country)) {
                    List<String> cities = countries.get(country);
                    cities.add(city);
                    countries.put(country, cities);
                } else {
                    List<String> cities = new ArrayList<>();
                    cities.add(city);
                    countries.put(country, cities);

                }
                continents.put(continent, countries);
            } else {
                LinkedHashMap<String, List<String>> countriesData = new LinkedHashMap<>();
                List<String> cities = new ArrayList<>();
                cities.add(city);
                countriesData.put(country, cities);
                continents.put(continent, countriesData);

            }
        }


        for (String continentName : continents.keySet()) {
            System.out.println(continentName + ":");
            LinkedHashMap<String, List<String>> countriesData = continents.get(continentName);
            for (String countryName : countriesData.keySet()) {
                System.out.print(countryName + " -> ");
                System.out.println(String.join(", ", countriesData.get(countryName)));
            }


        }

    }
}
