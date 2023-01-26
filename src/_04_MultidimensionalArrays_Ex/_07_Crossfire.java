package _04_MultidimensionalArrays_Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _07_Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);


        int counter = 1;
        List<List<Integer>> matrix = new ArrayList<>();

        for (int row = 0; row < rows; row++) {
            matrix.add(new ArrayList<>());
            for (int col = 0; col < cols; col++) {
                matrix.get(row).add(counter++);
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("Nuke it from orbit")){
            String [] tokens = command.split("\\s+");
            int rowDestroy = Integer.parseInt(tokens[0]);
            int colDestroy = Integer.parseInt(tokens[1]);
            int radius = Integer.parseInt(tokens[2]);

                int rowStart = Math.max(0, rowDestroy - radius);
                int rowEnd = Math.min(rows - 1, rowDestroy + radius);
                int colStart = Math.max(0, colDestroy - radius);
                int colEnd = Math.min(cols - 1, colDestroy + radius);

                for (int col = colStart; col <= colEnd; col++) {
                    if (inRange(rowDestroy, col, matrix))  {
                        matrix.get(rowDestroy).set(col, 0);
                    }
                }
                for (int row = rowStart; row <= rowEnd; row++) {
                    if (inRange(row, colDestroy, matrix)){
                        matrix.get(row).set(colDestroy, 0);
                    }
                }
            matrix.forEach(row -> row.removeIf(value -> value == 0));
            matrix.removeIf(List::isEmpty);


            command=scanner.nextLine();
        }
        System.out.println(getMatrixString(matrix));








    }



    private static boolean inRange(int row, int col, List<List<Integer>> matrix) {
        return row >= 0 && row < matrix.size() &&
                col >= 0 && col < matrix.get(row).size();
    }

    private static String getMatrixString(List<List<Integer>> matrix) {
        StringBuilder output = new StringBuilder();
        for (List<Integer> row : matrix) {
            output.append(row.toString().replaceAll("[\\[\\],]", ""));
            output.append(System.lineSeparator());
        }
        return output.toString();
    }

}

