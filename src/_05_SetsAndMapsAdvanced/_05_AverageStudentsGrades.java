package _05_SetsAndMapsAdvanced;

import java.util.*;

public class _05_AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>>namesWithGrades = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String [] tokens = scanner.nextLine().split("\\s+");
            String name = tokens[0];
            double grade= Double.parseDouble(tokens[1]);
            if(!namesWithGrades.containsKey(name)){
                List<Double>grades = new ArrayList<>();
                grades.add(grade);
                namesWithGrades.put(name, grades);
            }
            else {
                List <Double>grades = namesWithGrades.get(name);
                grades.add(grade);
                namesWithGrades.put(name, grades);
            }
        }

        for (String studentName : namesWithGrades.keySet()) {
            System.out.print(studentName + " -> ");
            double gradeSum = 0;
            List<Double> studentGrades = namesWithGrades.get(studentName);
            for (Double grade : studentGrades) {
                gradeSum += grade;
                System.out.printf("%.2f ", grade);
            }
            System.out.printf("(avg: %.2f)\n", Math.round(gradeSum / studentGrades.size() * 100) / 100.0);
        }

        }
}
