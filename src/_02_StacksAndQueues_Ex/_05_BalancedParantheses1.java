package _02_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_BalancedParantheses1 {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        //Четем скобите една по една:
        //- ако е отваряща, т.е. ( { [, я добавяме в стека
        //- ако е затваряща, т.е. ) } ], проверяваме в стека:
        //    ---- ако е празен => невалиден израз
        //    ---- ако скобата е от друг тип => невалиден израз
        //    ---- ако скобата е отваряща от правилния тип, продължаваме (след като сме я извадили от стека)
        //- като свършат всички входни данни, проверяваме дали стека е празен:
        //    ---- ако не е празен => невалиден израз
        //    ---- празен стек - всички скоби са формирали валидни двойки, т.е. изразът е валиден

        String input = scanner.nextLine();

        ArrayDeque<Character> openDecue = new ArrayDeque<>();

        if (input.length() % 2 != 0) {
            System.out.println("NO");

        } else {

            for (int i = 0; i < input.length(); i++) {
                char temp = input.charAt(i);
                if (temp == '(' || temp == '[' || temp == '{') {
                    openDecue.push(temp);
                } else {
                    switch (temp) {
                        case ')':
                            if (openDecue.peek().equals('('))
                                openDecue.pop();
                            break;
                        case ']':
                            if (openDecue.peek().equals('['))
                                openDecue.pop();
                            break;
                        case '}':
                            if (openDecue.peek().equals('{'))
                                openDecue.pop();
                            break;
                    }
                }
            }
            if (openDecue.isEmpty()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
