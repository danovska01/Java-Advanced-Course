package _10_FunctionalProgramming_Ex;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class _09_ListOfPredicates_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer > numbers = Arrays.stream(scanner.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        int n = Integer.parseInt(scanner.nextLine());
        BiFunction<Integer, List<Integer>, Boolean> isDivisible = ((number, list)-> {
            for (int numberInList:list){
                if(number%numberInList !=0){
                    return  false;
                }
            }
            return true;
        });

        for(int number =1; number<=n; number++){
            if(isDivisible.apply(number, numbers)){
                System.out.println(number);
            }
        }
    }
}
