package _02_StacksAndQueues_Ex;

import java.util.ArrayDeque;
import java.util.Scanner;

public class _05_BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        // !!!!!
        // Предложеното решение покрива само случаите, когато скобите са симетрични, например:
        // () или {()}
        // По условие и следните изрази са валидни:
        // ()() или []{}()



        String[] tokens = scanner.nextLine().split("");
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<String> stack = new ArrayDeque<>();
        // 1 ≤ Length of sequence ≤ 1000
        int lengthSequence = tokens.length;
        if (1 <= lengthSequence && lengthSequence <= 1000) {
            for (int i = 0; i < tokens.length; i++) {
                String current = tokens[i];
                queue.offer(current);
                stack.push(current);
            }
            boolean isTheSame = true;
            int size = queue.size();
            if (size == 1) {
            isTheSame=false;

            }
            for (int i = 0; i < size / 2; i++) {
                String firstSymbol = queue.poll();
                String closingSymbol = stack.pop();
                switch (firstSymbol) {
                    case "{":
                        if (closingSymbol.equals("}")) {
                            continue;
                        } else {
                            isTheSame = false;
                        }
                        break;
                    case "(":
                        if (closingSymbol.equals(")")) {
                            continue;
                        } else {
                            isTheSame = false;
                        }
                        break;
                    case "[":
                        if (closingSymbol.equals("]")) {
                            continue;
                        } else {
                            isTheSame = false;
                        }
                        break;
                    default:
                        isTheSame=false;
                        break;
                }
                if (isTheSame = false) {
                    break;
                }


            }
            if (!isTheSame) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }
    }
}
