package _03_MultidimensionalArrays;

import java.util.Scanner;

public class _02_PositionsOf {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String [] input= scanner.nextLine().split("\\s+");
    int rows= Integer.parseInt(input[0]);
    int cols= Integer.parseInt(input[1]);
    int [][]matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            String [] matrixRow= scanner.nextLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col]= Integer.parseInt(matrixRow[col]);
            }
        }
        int num = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                int currentNumFromMatrix = matrix[row][col];
                if(num==currentNumFromMatrix){
                    System.out.println(row + " " + col);
                    isFound=true;
                }


            }
        }

        if(!isFound){
            System.out.println("not found");
        }


    }



}
