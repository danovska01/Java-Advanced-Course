package _18_IteratorsAndComparators_Ex._3_StackIterator;

import java.util.ArrayDeque;
import java.util.Iterator;

public class Stack implements Iterable<Integer>{
    private Integer [] elements;
    private int index;


    public Stack(){
        this.elements = new Integer[16]; //There will be no more than 16 elements in the "Push" command.
        this.index = 0;
    }

    public void push(Integer... elements){
        for (Integer element : elements) {
            this.elements[this.index++] = element;
        }
    }

    public void pop(){ //If the "Pop" command could not be executed as expected (e.g. no elements in the stack), print on the console: "No elements".
        if (this.elements[0] == null){
            System.out.println("No elements");
        }else {
            this.elements[--this.index] = null;
        }

    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int index1 = index;
            @Override
            public boolean hasNext() {
                return index1 > 0;
            }

            @Override
            public Integer next() {
                return elements[--index1];
            }
        };
    }
}