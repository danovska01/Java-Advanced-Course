package _18_IteratorsAndComparators_Ex._1_ListIterator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //Create {} {} ....
        String createInput = scanner.nextLine();
        ArrayList<String>data = Arrays.stream(createInput.split("\\s+"))
                .skip(1).collect(Collectors.toCollection(ArrayList::new));

        ListIterator listIterator = new ListIterator(data);

        String command = scanner.nextLine();

        while (!command.equals("END")){

            switch (command){

                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.print());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

            }



            command=scanner.nextLine();
        }
    }
}
