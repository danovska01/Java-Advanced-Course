package _18_IteratorsAndComparators_Ex._1_ListIterator;

import java.util.ArrayList;
import java.util.List;

public class ListIterator {
    private static final int INIT_INDEX = -1;
    private List <String> data;
    private int index;

    public ListIterator(ArrayList<String> data) {
        this.data = data;
        if(this.data.isEmpty()){
            this.index=ListIterator.INIT_INDEX;
        }
        else {
            this.index=0;
        }
    }
    //Move - should move an internal index position to the next index in the list,
    // the method should return true if it successfully moved and false if there is no next index.
    public boolean move(){
        if(this.index<data.size()-1){
            this.index++;
            return true;
        }
        return false;
    }

    //HasNext - should return true if there is a next index and false if the index is already at the last element of the list.
    public boolean hasNext(){
        return this.index< data.size()-1;
    }

    //Print - should print the element at the current internal index,
    // calling Print on a collection without elements should throw an appropriate exception with the message "Invalid Operation!".
    public String print () {
        if(this.data.isEmpty()){
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
        else {
            return this.data.get(this.index);
        }
    }

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }



}
