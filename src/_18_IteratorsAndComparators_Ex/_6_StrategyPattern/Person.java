package _18_IteratorsAndComparators_Ex._6_StrategyPattern;

public class Person implements Comparable<Person>{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString(){
        return this.name+" "+this.age;
    }

    @Override
    public int compareTo(Person otherPerson) {
        int result = this.name.compareTo(otherPerson.name);
        if (result == 0) {
            result = this.age - otherPerson.age;
        }
        return result;
    }
}
