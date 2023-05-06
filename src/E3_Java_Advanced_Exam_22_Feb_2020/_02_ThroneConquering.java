package E3_Java_Advanced_Exam_22_Feb_2020;

import java.util.Objects;
import java.util.Scanner;

public class _02_ThroneConquering {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int energyOfParis = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String[][] playField = new String[size][size];

        int playerRow = -1;
        int playerCol = -1;

        int helenRow = -1;
        int helenCol = -1;

        for (int row = 0; row < size; row++) {
            String[] arr = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                playField[row][col] = arr[col];

                if (playField[row][col].equals("P")) {
                    playerRow = row;
                    playerCol = col;
                }

                if (playField[row][col].equals("H")) {
                    helenRow = row;
                    helenCol = col;
                }

            }
        }

        while (energyOfParis>0){
            String [] input = scanner.nextLine().split(" ");
            String direction= input[0];
            int spartanRow= Integer.parseInt(input[1]);
            int spartanCol= Integer.parseInt(input[2]);
            if(Objects.equals(playField[spartanRow][spartanCol], "P")){
                playField[spartanRow][spartanCol] = "X";
            }
            playField[spartanRow][spartanCol]="S";

            int oldRow = playerRow;
            int oldCol = playerCol;

            energyOfParis--;

            if (direction.equals("left")) {
                playerCol--;
            } else if (direction.equals("right")) {
                playerCol++;
            } else if (direction.equals("up")) {
                playerRow--;
            } else if (direction.equals("down")) {
                playerRow++;
            }
            // If Paris tries to move outside of the field, he doesn’t move but still has his energy decreased.
            if (playerCol < 0 || playerCol >= size || playerRow < 0 || playerRow >= size) {
                playerRow=oldRow;
                playerCol=oldCol;
                playField[playerRow][playerCol]="P";
            }

            //If an enemy is in the same cell where Paris moves, Paris fights him, which decreases his energy by 2.
            if (playerRow==spartanRow && playerCol==spartanCol){
                energyOfParis-=2;
                if(energyOfParis<=0){
                    playField[spartanRow][spartanCol]="X";//If Paris’ energy drops at 0 or below, he dies and you should mark his position with ‘X’.
                    playField[oldRow][oldCol]="-";//If Paris’ energy drops at 0 or below, he dies and you should mark his position with ‘X’.
                    break;
                }
                else {
                    playField[spartanRow][spartanCol]="-";
                    playField[playerRow][playerCol]="-";
                }
            }
            if (playerRow==helenRow && playerCol==helenCol){
                    playField[playerRow][playerCol]="-";
                    playField[oldRow][oldCol]="-";
                    break;

            }
            else {
                playField[oldRow][oldCol] = "-";
                playField[playerRow][playerCol] = "P";
            }


        }
        if (energyOfParis<=0){
            playField[playerRow][playerCol] = "X";
            System.out.printf("Paris died at %d;%d.%n", playerRow, playerCol);
        }
        if(playerRow==helenRow && playerCol==helenCol){
            System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", energyOfParis);

        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(playField[row][col]);
            }
            System.out.println();
        }


    }
}
