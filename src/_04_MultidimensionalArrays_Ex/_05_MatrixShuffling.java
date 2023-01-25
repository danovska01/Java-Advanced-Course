package _04_MultidimensionalArrays_Ex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class _05_MatrixShuffling {
    private static BufferedReader reader;
    private static String[][] matrix;
    private static int rows;
    private static int cols;

    static {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) throws IOException {
        readInput();

        String input;
        while (! "END".equals(input = reader.readLine())) {
            String[] tokens = input.split("\\s+");
            if (! input.startsWith("swap") || tokens.length != 5) {
                System.out.println("Invalid input!");
                continue;
            }

            int rowOne = Integer.parseInt(tokens[1]);
            int colOne = Integer.parseInt(tokens[2]);
            int rowTwo = Integer.parseInt(tokens[3]);
            int colTwo = Integer.parseInt(tokens[4]);

            if (isOutOfRange(rowOne, colOne, rowTwo, colTwo)) {
                System.out.println("Invalid input!");
                continue;
            }

            String temp = matrix[rowOne][colOne];
            matrix[rowOne][colOne] = matrix[rowTwo][colTwo];
            matrix[rowTwo][colTwo] = temp;
            System.out.print(getMatrixString());
        }
    }

    private static boolean isOutOfRange(int rowOne, int colOne, int rowTwo, int colTwo) {
        if (rowOne < 0 || rowOne >= rows) {
            return true;
        } else if (rowTwo < 0 || rowTwo >= rows) {
            return true;
        } else if (colOne < 0 || colOne >= cols) {
            return true;
        } else if (colTwo < 0 || colTwo >= cols) {
            return true;
        }
        return false;
    }

    private static void readInput() throws IOException {
        String[] size = reader.readLine().split("\\s+");
        rows = Integer.parseInt(size[0]);
        cols = Integer.parseInt(size[1]);
        matrix = new String[rows][cols];

        fillMatrix();
    }

    private static void fillMatrix() throws IOException {
        for (int row = 0; row < rows; row++) {
            String[] tokens = reader.readLine().split("\\s+");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = tokens[col];
            }
        }
    }

    private static String getMatrixString() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < rows; row++) {
            StringBuilder rowOutput = new StringBuilder();
            for (int col = 0; col < cols; col++) {
                rowOutput.append(matrix[row][col])
                        .append(" ");
            }
            output.append(rowOutput.toString().trim())
                    .append(System.lineSeparator());
        }
        return output.toString();
    }
}
