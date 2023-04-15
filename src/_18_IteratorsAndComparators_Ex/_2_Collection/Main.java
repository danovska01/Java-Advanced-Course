package _18_IteratorsAndComparators_Ex._2_Collection;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> data= Arrays.stream(scanner.nextLine().split("\\s+")).skip(1).collect(Collectors.toList());
        ListyIterator listyIterator = new ListyIterator(data);
        String command;
        while (!"END".equals(command=scanner.nextLine())){
            switch (command){
                case"HasNext":
                    System.out.println(listyIterator.iterator().hasNext());
                    break;
                case"Move":
                    System.out.println(listyIterator.move());
                    break;
                case"Print":
                    try{
                        listyIterator.print();
                    }catch (IllegalStateException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
                case"PrintAll":
                    try{
                        listyIterator.printAll();
                    }catch (IllegalStateException ex){
                        System.out.println(ex.getMessage());
                    }
                    break;
            }
        }
    }
}



