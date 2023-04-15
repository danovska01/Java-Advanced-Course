package _18_IteratorsAndComparators_Ex._4_Froggy;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Lake implements Iterable<Integer> { //Create a Class Lake, it should implement the interface - Iterable.
        private List<Integer> numbers;


        public Lake(){
            this.numbers = new ArrayList<>();

        }

        public void inputList(int element){
            numbers.add(element);
        }

        private final class Frog implements Iterator<Integer> { //Inside the Lake, create a Class - Frog and implement the interface Iterator.
            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return this.currentIndex < numbers.size() ;
            }

            @Override
            public Integer next() {
                int number = numbers.get(currentIndex);
                currentIndex += 2;
                if (currentIndex >= numbers.size() && currentIndex % 2 == 0){
                    currentIndex = 1;
                }
                return number;


            }
        }



        @Override
        public Iterator<Integer> iterator() {
            return new Frog();
        }
    }

