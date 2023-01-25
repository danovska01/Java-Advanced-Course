package _04_MultidimensionalArrays_Ex;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class _03_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Write a program that finds the difference between the sums of the square matrix diagonals (absolute value).
        int rows = Integer.parseInt(scanner.nextLine());
        int cols=rows;
        int [][]matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
                int [] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
                matrix[row]=arr;
        }
        int primaryDiagonalSum= findPrimaryDiagonalSum(rows, cols, matrix);
        int secondaryDiagonalSum= findSecondaryDiagonalSum(rows, cols, matrix);
        System.out.println(Math.abs(primaryDiagonalSum-secondaryDiagonalSum));

    }

    private static int findSecondaryDiagonalSum(int rows, int cols, int[][] matrix) {
        int sum=0;
        // it is on the secondary diagonal if col==matrix.length-row-1

        for (int row = 0; row < rows; row++) {
            for (int col = cols-1; col >= 0; col--) {
                sum+=matrix[row][col];
                row++;

            }
        }


        return sum;
    }

    private static int findPrimaryDiagonalSum(int rows, int cols, int[][] matrix) {
        int sum = 0;
        // it is on the primary diagonal if col==row
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                sum+=matrix[row][col];
                row++;

            }
        }




        return sum;


    }
}
