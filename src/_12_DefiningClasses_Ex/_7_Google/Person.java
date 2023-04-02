package _12_DefiningClasses_Ex._7_Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Pokemon> pokemons;
    private List<Parent> parents;
    private List<Child> children;

    public Person(String name) {
        this.name = name;
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void add(Parent parent) {
        this.parents.add(parent);
    }

    public void add(Child child) {
        this.children.add(child);
    }

    public void add(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name).append(System.lineSeparator());
        sb.append("Company:").append(System.lineSeparator());
        if (this.company != null) {
            sb.append(this.company).append(System.lineSeparator());
        }
        sb.append("Car:").append(System.lineSeparator());
        if (this.car != null) {
            sb.append(this.car).append(System.lineSeparator());
        }
        sb.append("Pokemon:").append(System.lineSeparator());
        this.pokemons.forEach(pokemon -> sb.append(pokemon).append(System.lineSeparator()));
        sb.append("Parents:").append(System.lineSeparator());
        this.parents.forEach(parent -> sb.append(parent).append(System.lineSeparator()));
        sb.append("Children:").append(System.lineSeparator());
        this.children.forEach(child -> sb.append(child).append(System.lineSeparator()));
        return sb.toString();
    }
}
