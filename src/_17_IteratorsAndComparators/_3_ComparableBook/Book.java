package _17_IteratorsAndComparators._3_ComparableBook;
import java.util.List;


public class Book implements Comparable<Book> {

    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, List<String> authors) {
        this.title = title;
        this.year = year;
        this.authors = authors;
    }

    public Book(String title, int year, String... authors) {
        this(title, year, List.of(authors));
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
        this.authors = List.of(authors);
    }



    @Override
    public int compareTo(Book otherBook) {

       /*if(this.getTitle().compareTo(otherBook.getTitle())==0){
           //the book titles are equal
           return Integer.compare(this.getYear(), otherBook.getYear());
       }
       return this.getTitle().compareTo(otherBook.getTitle());*/

        int result = this.getTitle().compareTo(otherBook.getTitle());
        if (result == 0) {
            //the book titles are equal
            result = Integer.compare(this.getYear(), otherBook.getYear());
        }
        return result;

    }

}
