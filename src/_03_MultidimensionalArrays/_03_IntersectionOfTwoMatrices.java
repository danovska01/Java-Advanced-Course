package _03_MultidimensionalArrays;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _03_IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char [][] matrixA = new char[rows][cols];
        char [][] matrixB = new char[rows][cols];

        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
            matrixA[row][col]=rowData[col].charAt(0);
            }
        }
        for (int row = 0; row < rows; row++) {
            String[] rowData = scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrixB[row][col]=rowData[col].charAt(0);
            }
        }
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if(matrixA[row][col]!=matrixB[row][col]){
                    System.out.print("* ");
                }
                else {
                    System.out.print(matrixA[row][col]+ " ");
                }
            }
            System.out.println();
        }
    }

}
