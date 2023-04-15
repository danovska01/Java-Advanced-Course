package _18_IteratorsAndComparators_Ex._3_StackIterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack stack = new Stack();
        String line = "";


        while (!(line = br.readLine()).equals("END")){
            line = line.replaceAll(",", "");
            String[] tokens = line.split("\\s+");

            switch (tokens[0]){
                case "Push":
                    stack.push(Arrays.stream(tokens).skip(1).mapToInt(Integer::parseInt).boxed().toArray(Integer[]::new));
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }


        }
        for (Integer i : stack) {
            System.out.println(i);
        }
        for (Integer i : stack) {
            System.out.println(i);
        }
    }

}
