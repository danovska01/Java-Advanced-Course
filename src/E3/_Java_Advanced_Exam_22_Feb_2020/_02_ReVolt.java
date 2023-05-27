package E3._Java_Advanced_Exam_22_Feb_2020;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _02_ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int numCommands = Integer.parseInt(scanner.nextLine());

        String[][] playField = new String[size][size];
        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                playField[row][col] = input[col];

                if (playField[row][col].equals("f")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }

        boolean playerWon = false;
        for (int i = 0; i < numCommands; i++) {
            String command = scanner.nextLine();
            int oldRow = playerRow;
            int oldCol = playerCol;

            if (command.equals("left")) {
                playerCol--;
            } else if (command.equals("right")) {
                playerCol++;
            } else if (command.equals("up")) {
                playerRow--;
            } else if (command.equals("down")) {
                playerRow++;
            }

            if (playerRow < 0 || playerRow >= size || playerCol < 0 || playerCol >= size) {
                playerRow = outOfMatrix(playerRow, size);
                playerCol = outOfMatrix(playerCol, size);
            }

            if (playField[playerRow][playerCol].equals("B")) {
                int[] newPosition = getBonus(playField, playerRow, playerCol, command);
                playerRow = newPosition[0];
                playerCol = newPosition[1];
            }

            if (playField[playerRow][playerCol].equals("T")) {
                playerRow = oldRow;
                playerCol = oldCol;
            }

            if (playField[playerRow][playerCol].equals("F")) {
                playerWon = true;
                playField[oldRow][oldCol] = "-";
                playField[playerRow][playerCol] = "f";
                break;
            }

            playField[oldRow][oldCol] = "-";
            playField[playerRow][playerCol] = "f";
        }

        if (playerWon) {
            System.out.println("Player won!");
        } else {
            System.out.println("Player lost!");
        }

        for (String[] row : playField) {
            System.out.println(Arrays.stream(row).collect(Collectors.joining()));
        }
    }

    private static int outOfMatrix(int coordinate, int size) {
        if (coordinate < 0) {
            return size - 1;
        } else if (coordinate >= size) {
            return 0;
        }
        return coordinate;
    }

    private static int[] getBonus(String[][] playField, int playerRow, int playerCol, String command) {
        int[] newPosition = {playerRow, playerCol};
        while (playField[newPosition[0]][newPosition[1]].equals("B")) {
            if (command.equals("left")) {
                newPosition[1]--;
            } else if (command.equals("right")) {
                newPosition[1]++;
            } else if (command.equals("up")) {
                newPosition[0]--;
            } else if (command.equals("down")) {
                newPosition[0]++;
            }
            newPosition[0] = outOfMatrix(newPosition[0], playField.length);
            newPosition[1] = outOfMatrix(newPosition[1], playField.length);
        }
        return newPosition;
    }
}
