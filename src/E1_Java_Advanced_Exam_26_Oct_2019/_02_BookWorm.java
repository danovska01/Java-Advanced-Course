package E1_Java_Advanced_Exam_26_Oct_2019;

import java.util.Scanner;

public class _02_BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        int size = Integer.parseInt(scanner.nextLine());

        String[][] playField = new String[size][size];

        int playerRow = 0;
        int playerCol = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                playField[row][col] = input[col];

                if (playField[row][col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                }
            }
        }
        StringBuilder sb = new StringBuilder(text);
        String command = scanner.nextLine();
        while (!command.equals("end")) {
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
            //If he tries to move outside of the field, he is punished -
            // he loses the last letter in the string, if there are any, and the player’s position is not changed.
            if (playerRow < 0 || playerRow >= size || playerCol < 0 || playerCol >= size) { //
                playerRow=oldRow;
                playerCol=oldCol;
                playField[playerRow][playerCol] = "P";
                if (sb.length()>1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            }
            //If he moves to a letter, he consumes it, concatеnates it to the initial string and the letter disappears from the field.
            if (!playField[playerRow][playerCol].equals("P") && !playField[playerRow][playerCol].equals("-")) {
                sb.append(playField[playerRow][playerCol]).charAt(0);
                playField[oldRow][oldCol] = "-";
                playField[playerRow][playerCol] = "P";

            }
            else {
                playField[oldRow][oldCol] = "-";
                playField[playerRow][playerCol] = "P";

            }


            command = scanner.nextLine();
        }

        System.out.println(sb);

        /*Arrays.stream(playField)
                .map(row -> Arrays.stream(row)
                        .map(String::valueOf)
                        .collect(Collectors.joining("")))
                .forEach(System.out::println);*/

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(playField[row][col]);
            }
            System.out.println();
        }

    }
}
