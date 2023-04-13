package _17_IteratorsAndComparators._2_Library;

import java.util.Iterator;

public class Library implements Iterable<Book>{
    private Book [] books;
    public Library (Book... books){
        this.books= books;
    }

    @Override
    public Iterator<Book> iterator() {
        return new LibraryIterator();
    }
    private final class LibraryIterator implements Iterator<Book>{
        private int index;

        public LibraryIterator() {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return this.index<books.length;
        }

        @Override
        public Book next() {
            return books[index++];
        }
    }
}
