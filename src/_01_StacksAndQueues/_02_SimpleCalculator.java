package _01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _02_SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        ArrayDeque<String>listOfSymbols= new ArrayDeque<>();

        for (int i = input.length-1; i >=0 ; i--) {
            listOfSymbols.push(input[i]);
        }
        while (listOfSymbols.size()>1){
            int firstNumber = Integer.parseInt(listOfSymbols.pop());
            String operator = listOfSymbols.pop();
            int secondNumber = Integer.parseInt(listOfSymbols.pop());
            int newNumber=0;
            if(operator.equals("+")){
                newNumber= firstNumber+secondNumber;
                listOfSymbols.push(String.valueOf(newNumber));
            }
            else if(operator.equals("-")){
                newNumber=firstNumber-secondNumber;
                listOfSymbols.push(String.valueOf(newNumber));
            }
        }
        String number = listOfSymbols.pop();
        System.out.println(number);


    }
}
