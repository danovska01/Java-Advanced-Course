package _06_SetsAndMapsAdvanced_Ex;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class _05_Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String>phonebook= new LinkedHashMap<>();
        String [] input = scanner.nextLine().split("-");
        while (!input[0].equals("search")){
              String name= input[0];
              String number= input[1];
              if(!phonebook.containsKey(name)){
                  phonebook.put(name,number);
              }
              else {
                  phonebook.put(name, number);
              }

            input= scanner.nextLine().split("-");
        }

        String nameToSearch = scanner.nextLine();
        while (!nameToSearch.equals("stop")){
            if(phonebook.containsKey(nameToSearch)){
                System.out.printf("%s -> %s%n", nameToSearch, phonebook.get(nameToSearch));
            }
            else {
                System.out.printf("Contact %s does not exist.%n", nameToSearch);
            }
            nameToSearch=scanner.nextLine();
        }

    }
}
