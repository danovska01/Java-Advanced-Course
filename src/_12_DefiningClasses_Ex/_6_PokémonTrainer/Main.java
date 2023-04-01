package _12_DefiningClasses_Ex._6_PokémonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static Map<String, Trainer> trainers = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {

        getPokemons();

        String line;
        while (!"End".equals(line = bufferedReader.readLine())) {
            //Fire", "Water", "Electricity" - if a trainer has at least 1 pokemon with the given element, if he does he receives 1 badge, otherwise, all his pokemon lose 10 health,
            String element = line;
            trainers.values().forEach(trainer -> trainer.processElement(element));
        }

        //sorted by the amount of badges they have in descending order
        trainers.values()
                .stream()
                .sorted(Trainer::compareTo)
                .forEach(System.out::println);
    }

    private static void getPokemons() throws IOException {
        String input;
        while (!"Tournament".equals(input = bufferedReader.readLine())) {
            String[] information = input.split(" ");

            String trainer = information[0];
            String pokemonName = information[1];
            String element = information[2];
            int health = Integer.parseInt(information[3]);

            trainers.putIfAbsent(trainer, new Trainer(trainer));
            trainers.get(trainer).add(new Pokemon(pokemonName, element, health));

        }
    }
}
