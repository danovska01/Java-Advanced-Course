package _18_IteratorsAndComparators_Ex._6_StrategyPattern;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        TreeSet<Person>peopleByNames=new TreeSet<>(new LengthOfNameComparator());
        TreeSet<Person>peopleByAges=new TreeSet<>(new AgeComparator());

        for (int i = 0; i < n; i++) {
            String [] input = scanner.nextLine().split(" ");
            String name = input[0];
            int age = Integer.parseInt(input[1]);

            Person person = new Person(name, age);
            peopleByNames.add(person);
            peopleByAges.add(person);

        }
        for (Person person : peopleByNames) {
            System.out.println(person.toString());
        }
        for (Person person : peopleByAges) {
            System.out.println(person.toString());
        }

    }
}
