package _03_MultidimensionalArrays;

import java.util.Arrays;
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


        //second way of reading matrix!!!
       scanner.nextLine();
        int[] dimensions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int rows2 = dimensions[0];
        int cols2 = dimensions[1];
        int[][] matrix2 = new int[rows2][cols2];

        for (int i = 0; i < rows2; i++) {
            int [] arr = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix2 [i]= arr;

        }
        boolean areEqual= matrixAreEqual (matrix, matrix2);
        if(areEqual){
            System.out.println("equal");
        }
        else {
            System.out.println("not equal");
        }



    }

    private static boolean matrixAreEqual(int[][] matrix, int[][] matrix2) {
        if(matrix.length!= matrix2.length){
            return false;
        }
        for (int row = 0; row < matrix.length; row++) {
            if(matrix[row].length!=matrix2[row].length){
                return false;
            }
            for (int col = 0; col < matrix.length; col++) {
                if(matrix[row][col]!=matrix2[row][col]){
                    return false;
                }
                
            }
            
        }
        return true;
    }

}
