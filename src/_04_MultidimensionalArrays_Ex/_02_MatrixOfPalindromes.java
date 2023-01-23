package _04_MultidimensionalArrays_Ex;

import java.util.Scanner;

public class _02_MatrixOfPalindromes {
    public static void main(String[] args) {
        //    • Rows define the first and the last letter: row 0 -> ‘a’, row 1 -> ‘b’, row 2 -> ‘c’, …
        //    • Columns + rows define the middle letter:
        //      ◦ column 0, row 0 -> ‘a’, column 1, row 0 -> ‘b’, column 2, row 0 -> ‘c’, …
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(String.valueOf(scanner.nextInt()));
        int cols = Integer.parseInt(String.valueOf(scanner.nextInt()));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("" + (char) ('a' + i) + (char) ('a' + i + j) + (char) ('a' + i) + ' ');
            }
            System.out.println();

        }
    }

}
