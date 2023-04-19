package Exam_Prep;

import java.util.Scanner;

public class _02_CookingJourney {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());

        String[][] pastyShop = new String[size][size];
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
                pastyShop[row][col]=input[col];

                if (pastyShop[row][col].equals("S")){
                currentRow= row;
                currentCol= col;
                }
                if (pastyShop[row][col].equals("P") && weFondFirstPillar==false){
                    firstPillarRow= row;
                    firstPillarCol= col;
                    weFondFirstPillar=true;
                }
                if (pastyShop[row][col].equals("P") && weFondFirstPillar==true){
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
                pastyShop[oldRow][oldCol] = "-";
                break;
            }

            if (currentCol==firstPillarCol && currentRow==firstPillarRow){
                //тук сме на 1-я пилон
                //тр.да отидем на втория
                currentCol=secondPillarCol;
                currentRow=secondPillarRow;
                pastyShop[oldRow][oldCol]= "-";
                pastyShop[firstPillarRow][firstPillarCol]= "-";
                pastyShop[currentRow][currentCol]= "S";
            }
            else if (currentCol==secondPillarCol && currentRow==secondPillarRow){
                //тук сме на 2-я пилон
                //тр.да отидем на 1-я
                currentCol=firstPillarCol;
                currentRow=firstPillarRow;
                pastyShop[oldRow][oldCol]= "-";
                pastyShop[secondPillarRow][secondPillarCol]= "-";
                pastyShop[currentRow][currentCol]= "S";

            }
            else if ((pastyShop[currentRow][currentCol]).equals("-")){
                //попадаме на празна клетка
                pastyShop[oldRow][oldCol]= "-";
                pastyShop[currentRow][currentCol]= "S";



            }
            else {
                //попадаме на клиент, тр. да му вземем парите
                money+=Integer.parseInt(pastyShop[currentRow][currentCol]);
                pastyShop[oldRow][oldCol]= "-";
                pastyShop[currentRow][currentCol]= "S";

            }
        }
        if (money>=50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        else {
            System.out.println("Bad news! You are out of the pastry shop.");
        }
        System.out.println("Money: " + money);
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(pastyShop[row][col]);
            }
            System.out.println();
        }



    }
}
