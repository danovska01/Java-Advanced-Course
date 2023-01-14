package _01_StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _04_MatchingBrackets {
    public static void main(String[] args) {

        // We are given an arithmetical expression with brackets. Scan through the string and extract each sub-expression.
        //

        // input: 1 + (2 - (2 + 3) * 4 / (3 + 1)) * 5
        // output: (2 + 3)
        //         (3 + 1)
        //         (2 - (2 + 3) * 4 / (3 + 1))
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        char [] input = expression.toCharArray();
        ArrayDeque<Integer>stack = new ArrayDeque<>();
        for (int i = 0; i < input.length; i++) {
            char ch = input [i];
            if(ch!=' '){

                if(ch=='('){
                    stack.push(i);
                }
                else if (ch==')'){
                    int startIndex = stack.pop();
                    String contests = expression.substring(startIndex, i + 1);
                    System.out.println(contests);

                }

            }

        }
    }
}
