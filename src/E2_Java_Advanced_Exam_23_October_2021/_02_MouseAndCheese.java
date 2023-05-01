package E2_Java_Advanced_Exam_23_October_2021;

import java.util.Scanner;

public class _02_MouseAndCheese {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        String[][] mouseTerritory = new String[size][size];

        int mouseRow = 0;
        int mouseCol = 0;

        for (int row = 0; row < size; row++) {
            String[] input = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                mouseTerritory[row][col] = input[col];

                if (mouseTerritory[row][col].equals("M")) {
                    mouseRow = row;
                    mouseCol = col;
                }
            }
        }

        int cheese = 0;
        boolean isMouesOut = false;

        String command = scanner.nextLine();
        while (!command.equals("end")) {
            int oldRow = mouseRow;
            int oldCol = mouseCol;

            if (command.equals("left")) {
                mouseCol--;
            } else if (command.equals("right")) {
                mouseCol++;
            } else if (command.equals("up")) {
                mouseRow--;
            } else if (command.equals("down")) {
                mouseRow++;
            }

            //If the mouse goes out she can't return and the program ends.
            if (mouseCol < 0 || mouseCol >= size || mouseRow < 0 || mouseRow >= size) {
                mouseTerritory[oldRow][oldCol] = "-";
                isMouesOut = true;
                break;
            }
            //If the mouse moves to cheese, it eats the cheese and increases the cheese it has eaten by one.
            if (mouseTerritory[mouseRow][mouseCol].equals("c")) {
                cheese++;
                mouseTerritory[oldRow][oldCol] = "-";
                mouseTerritory[mouseRow][mouseCol] = "M";
            }
            //If it goes to a bonus, the mouse gets a bonus one move forward and then the bonus disappears.
            if (mouseTerritory[mouseRow][mouseCol].equals("B")) {
                mouseTerritory[oldRow][oldCol] = "-";
                mouseTerritory[mouseRow][mouseCol] = "M";
                oldRow = mouseRow;
                oldCol = mouseCol;

                if (command.equals("left")) {
                    mouseCol--;
                } else if (command.equals("right")) {
                    mouseCol++;
                } else if (command.equals("up")) {
                    mouseRow--;
                } else if (command.equals("down")) {
                    mouseRow++;
                }

                if (mouseCol < 0 || mouseCol >= size || mouseRow < 0 || mouseRow >= size) {
                    mouseTerritory[oldRow][oldCol] = "-";
                    isMouesOut = true;
                    break;
                }
                if (mouseTerritory[mouseRow][mouseCol].equals("c")) {
                    cheese++;
                    mouseTerritory[oldRow][oldCol] = "-";
                    mouseTerritory[mouseRow][mouseCol] = "M";
                } else {
                    mouseTerritory[oldRow][oldCol] = "-";
                    mouseTerritory[mouseRow][mouseCol] = "M";
                }

            }

            else {
                mouseTerritory[oldRow][oldCol] = "-";
                mouseTerritory[mouseRow][mouseCol] = "M";
            }
            command = scanner.nextLine();
        }

        if (isMouesOut) {
            System.out.println("Where is the mouse?");
        }
        if (cheese < 5) {
            System.out.printf("The mouse couldn't eat the cheeses, she needed %d cheeses more.%n", 5 - cheese);
        } else {
            System.out.printf("Great job, the mouse is fed %d cheeses!%n", cheese);
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(mouseTerritory[row][col]);
            }
            System.out.println();
        }
    }
}
