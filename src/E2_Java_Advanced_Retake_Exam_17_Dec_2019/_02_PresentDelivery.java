package E2_Java_Advanced_Retake_Exam_17_Dec_2019;

import java.util.Scanner;

public class _02_PresentDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int countPresents = Integer.parseInt(scanner.nextLine());
        int size = Integer.parseInt(scanner.nextLine());

        String [][] neighbourHood = new String[size][size];

        int santaRow = 0;
        int santaCol = 0;

        for (int row = 0; row< size; row++){
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < size; col++) {
                neighbourHood[row][col]=input[col];

                if (neighbourHood[row][col].equals("S")) {
                    santaRow = row;
                    santaCol = col;
                }

            }
        }
        int numberPresentsGivenToGoodKids=0;
        String command = scanner.nextLine();
        while (!command.equals("Christmas morning")){

            int oldRow= santaRow;
            int oldCol= santaCol;

            if(command.equals("left")){
                santaCol--;
            }
            if(command.equals("right")){
                santaCol++;
            }
            if(command.equals("down")){
                santaRow++;
            }
            if(command.equals("up")){
                santaRow--;
            }

            if(neighbourHood[santaRow][santaCol].equals("V")){
                countPresents--;
                numberPresentsGivenToGoodKids++;
                neighbourHood[oldRow][oldCol]="-";
                neighbourHood[santaRow][santaCol]="S";
            }
            if(neighbourHood[santaRow][santaCol].equals("X")){
                neighbourHood[oldRow][oldCol]="-";
                neighbourHood[santaRow][santaCol]="S";
            }
            if(neighbourHood[santaRow][santaCol].equals("C")){
                neighbourHood[oldRow][oldCol]="-";
                neighbourHood[santaRow][santaCol]="S";

                //left, right, upwards, and downwards

                countPresents--;
                if(neighbourHood[santaRow][santaCol-1].equals("Y")){
                    numberPresentsGivenToGoodKids++;
                }
                neighbourHood[santaRow][santaCol-1]="-";
                if (countPresents<=0){
                    break;
                }


                countPresents--;
                if(neighbourHood[santaRow][santaCol+1].equals("Y")){
                    numberPresentsGivenToGoodKids++;
                }
                neighbourHood[santaRow][santaCol+1]="-";
                if (countPresents<=0){
                    break;
                }

                countPresents--;
                if(neighbourHood[santaRow-1][santaCol].equals("Y")){
                    numberPresentsGivenToGoodKids++;
                }
                neighbourHood[santaRow-1][santaCol]="-";
                if (countPresents<=0){
                    break;
                }

                countPresents--;
                if(neighbourHood[santaRow+1][santaCol].equals("Y")){
                    numberPresentsGivenToGoodKids++;
                }
                neighbourHood[santaRow+1][santaCol]="-";
                if (countPresents<=0){
                    break;
                }

            }
            else if (neighbourHood[santaRow][santaCol].equals("-")) {
                neighbourHood[oldRow][oldCol] = "-";
                neighbourHood[santaRow][santaCol] = "S";
            }
            if (countPresents<=0){
                break;
            }
            command= scanner.nextLine();
        }
        if(countPresents<=0){
            System.out.println("Santa ran out of presents!");
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.print(neighbourHood[row][col] + " ");
            }
            System.out.println();
        }
        int goodKids=0;
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if(neighbourHood[row][col].equals("V")){
                    goodKids++;
                };
            }
        }
        if(goodKids==0){
            System.out.printf("Good job, Santa! %d happy nice kid/s.%n",numberPresentsGivenToGoodKids);
        }
        else {
            System.out.printf("No presents for %d nice kid/s.%n", goodKids);
        }

    }

}
