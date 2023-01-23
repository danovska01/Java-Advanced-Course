package _03_MultidimensionalArrays;

import java.util.Scanner;

public class _07_FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = 8;
        int cols = 8;
        char [][] matrix= new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col]=rowData[col].charAt(0);
            }
        }



    }
}
