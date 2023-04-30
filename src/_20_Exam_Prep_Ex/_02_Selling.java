package _20_Exam_Prep_Ex;

import java.util.Scanner;

public class _02_Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] bakeryShop = new String[size][size];

        int currentRow = 0;
        int currentCol = 0;

        int firstPillarRow=0;
        int firstPillarCol=0;

        int secondPillarRow=0;
        int secondPillarCol=0;

        boolean weFondFirstPillar=false;

        for (int row = 0; row < size; row++) {
            String [] input = scanner.nextLine().split("");
            for (int col = 0; col < size; col++) {
                bakeryShop[row][col]=input[col];

                if (bakeryShop[row][col].equals("S")){
                    currentRow= row;
                    currentCol= col;
                }
                if (bakeryShop[row][col].equals("O") && !weFondFirstPillar){
                    firstPillarRow= row;
                    firstPillarCol= col;
                    weFondFirstPillar=true;
                }
                if (bakeryShop[row][col].equals("O") && weFondFirstPillar){
                    secondPillarRow= row;
                    secondPillarCol= col;

                }

            }

        }

        int money= 0;
        while (money<50){
            String command = scanner.nextLine();

            int oldRow = currentRow;
            int oldCol = currentCol;

            if(command.equals("left")){
                currentCol--;
            }
            else if (command.equals("right")){
                currentCol++;
            }
            else if (command.equals("up")){
                currentRow--;
            }
            else if (command.equals("down")){
                currentRow++;
            }
            if(currentRow<0 || currentRow>=size || currentCol<0 || currentCol>=size){
                bakeryShop[oldRow][oldCol] = "-";
                break;
            }

            if (currentCol==firstPillarCol && currentRow==firstPillarRow){
                //тук сме на 1-я пилон
                //тр.да отидем на втория
                currentCol=secondPillarCol;
                currentRow=secondPillarRow;
                bakeryShop[oldRow][oldCol]= "-";
                bakeryShop[firstPillarRow][firstPillarCol]= "-";
                bakeryShop[currentRow][currentCol]= "S";
            }
            else if (currentCol==secondPillarCol && currentRow==secondPillarRow){
                //тук сме на 2-я пилон
                //тр.да отидем на 1-я
                currentCol=firstPillarCol;
                currentRow=firstPillarRow;
                bakeryShop[oldRow][oldCol]= "-";
                bakeryShop[secondPillarRow][secondPillarCol]= "-";
                bakeryShop[currentRow][currentCol]= "S";

            }
            else if ((bakeryShop[currentRow][currentCol]).equals("-")){
                //попадаме на празна клетка
                bakeryShop[oldRow][oldCol]= "-";
                bakeryShop[currentRow][currentCol]= "S";



            }
            else {
                //попадаме на клиент, тр. да му вземем парите
                money+=Integer.parseInt(bakeryShop[currentRow][currentCol]);
                bakeryShop[oldRow][oldCol]= "-";
                bakeryShop[currentRow][currentCol]= "S";

            }
        }
        if (money>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        else {
            System.out.println("Bad news, you are out of the bakery.");
        }
        System.out.println("Money: " + money);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(bakeryShop[row][col]);
            }
            System.out.println();
        }
    }
}

// INPUT:
/*6
S98---
99----
666666
------
--77--
-6-6-6
right
right
down
left
left
down
right
right*/
