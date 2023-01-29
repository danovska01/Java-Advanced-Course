package _05_SetsAndMapsAdvanced;

import java.util.*;

public class _08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, List<Double>> log = new TreeMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            String[] numbers =scanner.nextLine().split(" ");
            List<Double> scores = new ArrayList<>();
            for (int j = 0; j <=numbers.length-1 ; j++) {
                double current = Double.parseDouble(numbers[j]);
                scores.add(current);
            }
            log.putIfAbsent(name, scores);
        }

        for(String name: log.keySet()) {
            double average = log.get(name).stream().mapToDouble(i -> i).average().getAsDouble();
            System.out.println(name + " is graduated with " + average);
        }

        // Map<String, Double> log = new TreeMap<>();
        // int n = Integer.parseInt(scanner.nextLine());

       /* for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double averageScore = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .average().getAsDouble();

            log.put(name, averageScore);

        }
        for (String studentName : log.keySet()) {
            System.out.println(studentName + " is graduated with " + log.get(studentName));
        }*/
    }
}
