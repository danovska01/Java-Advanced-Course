package _17_IteratorsAndComparators._2_Library2;

public class Main {

        public static void main(String[] args) {
            Book one = new Book("Animal farm", 2003, "George Orwell");
            Book two = new Book("The Documents in the case", 1930, "Dorothy Sayers", "Robert Eus..");
            Book three = new Book("The Document in the Case", 2002);

            Library library = new Library();
            library.add(one);
            library.add(two);
            library.add(three);

            for(Book next : library){
                System.out.println(next.getTitle());
            }
    }

}
