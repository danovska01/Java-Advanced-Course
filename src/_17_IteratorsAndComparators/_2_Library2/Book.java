package _17_IteratorsAndComparators._2_Library2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Book {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... authors) {
        this.title = title;
        this.year = year;
        this.setAuthors(authors);
        //this.authors= new ArrayList<>(Arrays.asList(authors)); // превръщаме масива, който получаваме при точките горе директно в списък

    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(String... authors) {
        this.authors = Arrays.stream(authors).collect(Collectors.toList());
    }



}
