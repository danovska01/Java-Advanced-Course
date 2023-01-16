package _03_MultidimensionalArrays;

import java.util.Scanner;

public class _04_SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        int sum = 0;

        for (int row = 0; row < rows; row++) {
            String [] matrixRow = scanner.nextLine().split(", ");
            for (int col = 0; col < cols; col++) {
             matrix[row][col]= Integer.parseInt(matrixRow[col]);
             sum+=Integer.parseInt(matrixRow[col]);
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);

    }
}
