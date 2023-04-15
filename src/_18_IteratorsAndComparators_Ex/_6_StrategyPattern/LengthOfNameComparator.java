package _18_IteratorsAndComparators_Ex._6_StrategyPattern;

import java.util.Comparator;

public class LengthOfNameComparator implements Comparator<Person> {
    @Override
    public int compare(Person person1, Person person2) {
        int result = Integer.compare(person1.getName().length(), person2.getName().length());
        if(result==0){//perform a case-insensitive compare based on the first letter of their name instead
            result= person1.getName().toLowerCase().charAt(0) - person2.getName().toLowerCase().charAt(0);;
        }
        return result;
    }
}
