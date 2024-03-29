package E2_Java_Advanced_Retake_Exam_17_Dec_2019;

import java.util.Scanner;

public class _02 {

    private static int rowMatrix = 0;
    private static int santaRow = -1;
    private static int santaCol = -1;
    private static int niceKids = 0;
    private static int presents = 0;
    private static String command = null;
    private static char[][] matrix = null;
    private static int allNiceKids = 0;

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        presents = Integer.parseInt(console.nextLine());
        rowMatrix = Integer.parseInt(console.nextLine());
        matrix = new char[rowMatrix][rowMatrix];

        fillMatrix(matrix, console);



        while (presents > 0 && !"Christmas morning".equals(command = console.nextLine())) {
            matrix[santaRow][santaCol] = '-';
            changePosition();

            if (matrix[santaRow][santaCol] == 'V') {
                presents--;
                niceKids--;
                allNiceKids++;
            }

            if (matrix[santaRow][santaCol] == 'C') {
                givePresent(matrix, 1, 0);
                givePresent(matrix, -1, 0);
                givePresent(matrix, 0, 1);
                givePresent(matrix, 0, -1);
            }
        }

        matrix[santaRow][santaCol] = 'S';
        if (presents == 0) {
            System.out.println("Santa ran out of presents!");
        }

        printMatrix();

        if (niceKids <= 0) {
            System.out.println("Good job, Santa! " + allNiceKids + " happy nice kid/s.");
        } else {
            System.out.println("No presents for " + niceKids + " nice kid/s.");
        }

    }

    private static void printMatrix() {
        for (char[] chars : matrix) {
            for (char aChar : chars) {
                System.out.print(aChar + " ");
            }
            System.out.println();
        }
    }

    private static void givePresent(char[][] matrix, int rowMutator, int colMutator) {
        if (matrix[santaRow + rowMutator][santaCol + colMutator] == 'X') {
            presents--;
            allNiceKids++;
        }
        if (matrix[santaRow + rowMutator][santaCol + colMutator] == 'V') {
            presents--;
            niceKids--;
            allNiceKids++;
        }
        matrix[santaRow + rowMutator][santaCol + colMutator] = '-';
    }

    private static void fillMatrix(char[][] matrix, Scanner console) {
        for (int i = 0; i < rowMatrix; i++) {
            String[] input = console.nextLine().split("\\s+");
            for (int j = 0; j < input.length; j++) {
                matrix[i][j] = input[j].charAt(0);
                if (matrix[i][j] == 'S') {
                    santaRow = i;
                    santaCol = j;
                    matrix[i][j] = '-';
                }
                if (matrix[i][j] == 'V') {
                    niceKids++;
                }
            }
        }
    }

    public static boolean InTheMatrix(int rowMutator, int colMutator, int rowMatrix) {
        return santaRow + rowMutator >= 0 && santaRow + rowMutator < rowMatrix && santaCol + colMutator >= 0 && santaCol + colMutator < rowMatrix;
    }

    public static void changePosition() {
        switch (command) {
            case "up":
                if (InTheMatrix(-1, 0, rowMatrix)) {santaRow--;}break;
            case "down":
                if (InTheMatrix(1, 0, rowMatrix)) break;
            case "left":
                if (InTheMatrix(0, -1, rowMatrix)) {santaCol--;}break;
            case "right":
                if (InTheMatrix(0, 1, rowMatrix)) {santaCol++;}break;
        }
    }
}