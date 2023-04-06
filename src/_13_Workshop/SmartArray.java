package _13_Workshop;

import java.util.function.Consumer;

public class SmartArray {
    public static final int INITIAL_CAPACITY=4;
    public static final int INITIAL_SIZE=0;
    public static final int SHRINK_THRESHOLD=4;

    private int [] data ; // An array that will hold all of our elements
    private int size; // Holds the size with real data of the array
    private int capacity; // Holds the size of the array

    public SmartArray() {
        this.size = INITIAL_SIZE;
        this.capacity = INITIAL_CAPACITY;
        this.data = new int [INITIAL_CAPACITY];
    }
    public void add (int element){ //void add(int element) - Adds the given element to the end of the list
        this.ensureCapacity();
        this.data[size]=element;
        this.size++;
    }
    public void resize (){ //this method will be used to increase the internal collection's length twice
        this.capacity= capacity*2;
        int [] temp = new int[capacity];
        for (int i = 0; i <this.size ; i++) {
            temp[i]=this.data[i];
        }
        this.data=temp;
    }
    public int size (){
        return  this.size;
    }

    private void ensureCapacity() {
        if(this.size==this.capacity){
            this.resize();
        }
    }

    public int get (int index){ //int get(int index) - Returns the element at the specified position in this list
        this.checkIndex(index);
        return this.data[index];
    }
    public int remove (int index){ //int remove(int index) - Removes the element at the given index
        int numberToRemove= this.get(index);
        this.shift(index);
        this.size--;
        if(this.capacity/this.size>SHRINK_THRESHOLD){
            this.shrink();
        }
        return numberToRemove;
    }

    public void shrink() {
        this.capacity=this.capacity/2;
        int temp [] = new  int [this.capacity];
        for (int i =0; i < this.size; i++){
            temp[i]=this.data[i];
        }
        this.data=temp;
    }
    public void forEach (Consumer<Integer>consumer){
        for ( int i=0; i < this.size; i++) {
            consumer.accept (this.data[i]);
        }
    }


    private void shift(int index) {
        for (int i = index + 1; i < this.size; i++) {
            this.data[i-1]=this.data[i];
        }
        this.data[size-1]=0;
    }
    public boolean contains (int element){
        for (int i = 0; i < this.size; i++) {
            if(this.data[i]==element){
                return true;
            }

        }
        return false;
    }
    public void shiftRight (int index, int element){
        this.checkIndex(index);
        this.ensureCapacity();
        this.size++;
        this.shiftRight(index);
        this.data[index]=element;
    }

    private void shiftRight(int index) {
        for (int i = this.size-1; i >index ; i--) {
            this.data[i]=this.data[i-1];

        }
    }

    private void checkIndex(int index) {
        if(index>=this.size || index<0){
            String errorMessage = String.format("Index %d is out of bounds for our SmartArray", index);
            throw new IndexOutOfBoundsException(errorMessage);
        }
    }


}
