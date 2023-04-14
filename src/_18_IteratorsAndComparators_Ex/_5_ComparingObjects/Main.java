package _18_IteratorsAndComparators_Ex._5_ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Person> listOfPeople = new ArrayList<>();


        String [] information = scanner.nextLine().split("\\s+");

        while (!information[0].equals("END")){
            //"{name} {age} {town}"
            String name= information[0];
            int age = Integer.parseInt(information[1]);
            String town = information[2];

            Person person = new Person(name, age, town);
            listOfPeople.add(person);

            information = scanner.nextLine().split("\\s+");
        }

        //After that, you will receive an integer N - the Nth person in your collection.
        //Bring statistics, how many people are equal to him, how many people are not equal to him, and the total people in your collection ->
        // ->>>  "{number of equal people} {number of not equal people} {total number of people}"
        // If there are no equal people print: "No matches".

        int n = Integer.parseInt(scanner.nextLine()); // търсим n-тия човек, индексът му е n-1, броим от 0

        Person comparePerson = listOfPeople.get(n - 1);

        /* int count = 0; // брой на хората еднакви с comparePerson
        for(Person person: listOfPeople){
            // сравнявам comparePerson и person
            if(comparePerson.compareTo(person)==0){
                count++;
            }
        }
        if (count<=1){ //понеже ще намери един еднакъв, като го сравним със себе си; взимаме даден човек от списъка и го сравняваме със всички в списъка, вкл. и с него
            System.out.println("No matches");
        }
        else {
            System.out.printf("%d %d %d", count, listOfPeople.size()-count, listOfPeople.size());
        }*/

        int equalPeople = (int) listOfPeople.stream()
                .filter(p -> p.compareTo(comparePerson) == 0)
                .count();

        if(equalPeople==1){
            System.out.println("No matches");
        }else{
            System.out.println(String.format("%d %d %d",equalPeople,listOfPeople.size()-equalPeople,listOfPeople.size()));
        }


    }
}
