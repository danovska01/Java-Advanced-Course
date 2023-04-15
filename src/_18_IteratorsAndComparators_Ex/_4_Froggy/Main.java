package _18_IteratorsAndComparators_Ex._4_Froggy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        Lake lake = new Lake();
        String line = scanner.nextLine();

        while (!line.equals("END")){
            String[] tokens = line.split(",\\s+");
            for (int i = 0; i < tokens.length ; i++) {
                lake.inputList(Integer.parseInt(tokens[i]));
            }
            line=scanner.nextLine();
        }


        StringBuilder sb = new StringBuilder();

        for (Integer integer : lake) {
            sb.append(integer).append(", ");
        }
        System.out.println(sb.toString().substring(0,sb.toString().lastIndexOf(", ")));


        /*sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);*/
    }
}
