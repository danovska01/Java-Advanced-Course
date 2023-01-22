package _03_MultidimensionalArrays;

import java.util.Scanner;


public class _01_CompareMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
     int rows = Integer.parseInt(String.valueOf(scanner.nextInt()));
     int cols = Integer.parseInt(String.valueOf(scanner.nextInt()));
     int [][] matrix1 = new int [rows][cols];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix1[i][j]=Integer.parseInt(String.valueOf(scanner.nextInt()));
            }

        }
        int rows2 = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int cols2 = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int [][] matrix2 = new int [rows2][cols2];

        for (int i = 0; i < rows2; i++) {
            for (int j = 0; j < cols2; j++) {
                matrix2[i][j]=Integer.parseInt(String.valueOf(scanner.nextInt()));
            }

        }

        boolean areEqual= matrixAreEqual(matrix1, matrix2);
        if(areEqual){
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }

    }

    private static boolean matrixAreEqual(int[][] matrix1, int[][] matrix2) {
     if(matrix1.length!=matrix2.length){
         return false;
     }
        for (int row = 0; row < matrix1.length; row++) {
            if(matrix1[row].length!=matrix2[row].length){
                return false;
            }
            for (int col = 0; col < matrix1[row].length; col++) {
                if(matrix1[row][col]!=matrix2[row][col]){
                    return false;
                }
            }
            
        }



        return true;
    }


}
