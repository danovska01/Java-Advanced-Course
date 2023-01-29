package _05_SetsAndMapsAdvanced;

import java.util.*;

public class _08_AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> log = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String name = scanner.nextLine();
            Double averageScore = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToDouble(Double::parseDouble)
                    .average().getAsDouble();

            log.put(name, averageScore);

        }
        for (String studentName : log.keySet()) {
            System.out.println(studentName + " is graduated with " + log.get(studentName));
        }
    }
}
