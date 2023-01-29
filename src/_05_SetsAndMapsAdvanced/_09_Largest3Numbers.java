package _05_SetsAndMapsAdvanced;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class _09_Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Read a list of integers and print the largest 3 of them. If there are less than 3, print all of them.

        List<Integer> sorted= Arrays
                .stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).sorted((n1, n2) -> n2.compareTo(n1))
                .collect(Collectors.toList());
        int counter = 0;
        for(int n : sorted){
            if (counter==3){
                break;}
            System.out.print(n+ " ");
            counter++;

            }

    }
}
