package _05_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class _02_SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String>vip = new TreeSet<>();
        Set<String>regular = new TreeSet<>();

        while (!input.equals("PARTY")){
            if(Character.isDigit(input.charAt(0))){
                vip.add(input);
            }
            else {
                regular.add(input);
            }

            input=scanner.nextLine();
        }
        String input2= scanner.nextLine();
        while (!input2.equals("END")){
            if(Character.isDigit(input2.charAt(0))){
                vip.remove(input2);
            }
            else {
                regular.remove(input2);
            }

            input2=scanner.nextLine();
        }
        int counter= counter(vip, regular);
        System.out.println(counter);

        for (String currentVip: vip){
            System.out.println(currentVip);
        }
        for (String currentRegular: regular){
            System.out.println(currentRegular);
        }




    }

    private static int counter( Set<String> vip, Set<String> regular) {
        int counter = 0;
        for (String currentVip: vip){
            counter++;
        }
        for (String currentRegular: regular){
            counter++;
        }

        return counter;
    }
}
