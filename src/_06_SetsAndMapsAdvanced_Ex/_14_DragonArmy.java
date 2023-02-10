package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _14_DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, TreeMap<String, Long[]>> dragonsLog= new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            //If a stat is missing you should assign its default values. Default values are as follows:
            // health - 250, damage - 45, and armor - 10. Missing stat will be marked by null.
            String type = tokens[0];
            String name = tokens[1];
            long damage = tokens[2].equals("null") ? 45 : Long.parseLong(tokens[2]);
            long health = tokens[3].equals("null") ? 250 : Long.parseLong(tokens[3]);
            long armour = tokens[4].equals("null") ? 10 : Long.parseLong(tokens[4]);

            dragonsLog.putIfAbsent(type, new TreeMap<>());
            dragonsLog.get(type).putIfAbsent(name, new Long[3]);

            dragonsLog.get(type).get(name)[0] = damage;
            dragonsLog.get(type).get(name)[1] = health;
            dragonsLog.get(type).get(name)[2] = armour;
        }

        for (Map.Entry<String, TreeMap<String, Long[]>> type : dragonsLog.entrySet()) {
            TreeMap<String, Long[]> typeDragons = type.getValue();

            double damageAverage = 0;
            double healthAverage = 0;
            double armorAverage = 0;

            for (Map.Entry<String, Long[]> dragon : typeDragons.entrySet()) {
                damageAverage += dragon.getValue()[0];
                healthAverage += dragon.getValue()[1];
                armorAverage += dragon.getValue()[2];
            }

            int size = typeDragons.size();

            damageAverage /= size;
            healthAverage /= size;
            armorAverage /= size;

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type.getKey(), damageAverage, healthAverage, armorAverage);

            typeDragons.entrySet()
                    .forEach(x -> {
                        Long[] stats = x.getValue();
                        long dragonDamage = stats[0];
                        long dragonHealth = stats[1];
                        long dragonArmor = stats[2];

                        System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n",
                                x.getKey(), dragonDamage, dragonHealth, dragonArmor);
                    });
        }
        



    }
}
