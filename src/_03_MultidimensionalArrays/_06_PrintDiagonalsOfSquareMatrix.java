package _03_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class _06_PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols= rows;
        int [][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {

            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[row]=arr;

        }
        int currentCol=0;
        for (int row = 0; row < rows; row++) {

            for (int col= currentCol; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
                break;
            }
            currentCol++;
        }
        System.out.println();
        currentCol=0;
        for (int row = rows-1; row >=0 ; row--) {

        for (int col = currentCol; col <cols; col++) {
            System.out.print(matrix[row][col] + " ");
            break;
        }
        currentCol++;
        }
    }
}
