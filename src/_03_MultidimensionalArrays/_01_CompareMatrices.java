package _03_MultidimensionalArrays;

import java.util.Scanner;

public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int cols = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int[][] matrix = new int[rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(scanner.nextInt()));
            }

        }
        int rows2 = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int cols2 = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int[][] matrix2 = new int[rows2][cols2];

        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j] = Integer.parseInt(String.valueOf(scanner.nextInt()));
            }

        }

    }

}
