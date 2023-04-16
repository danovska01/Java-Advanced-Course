package _14_Workshop_Ex;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList {
    //глава
    private Node head;
    //опашка
    private Node tail;
    //размер
    private int size;

    public void addFirst(int value){
        //добавя нод/елемент в началото на списъка
        //1. създаваме нов нод
         Node newNode = new Node(value);
        //2.проверка дали списъкът е празен
        if(isEmpty()){ //празен- първият и последният елемент са еднакви
        this.head=newNode;
        this.tail=newNode;
        }
        else { //не е празен списъкът
            newNode.next=head; //новия нод, следващият елемент става равен на текущата глава;
            this.head.prev= newNode;
            this.head=newNode; //смяна на главата, преди това нодовете са модифицирани по между им;

        }
        this.size++;

    }

    public void addLast (int value){//добавя елемент/нод в края на списъка
        if(isEmpty()){ //празен
            addFirst(value);
            //не увеличаваме с 1 (++), понеже в addFirst вече имаме увеличаване
        }
        else { //не е празен списъкът
            Node newNode = new Node(value);
            this.tail.next= newNode;
            newNode.prev=this.tail; //новия нод, предишният елемент става равен на текущата опашка;
            this.tail=newNode; //смяна на опашката, преди това нодовете са модифицирани по между им;
            this.size++;
        }

    }

    public int get (int index){
        // стойността на съответния индекс
        //проверка дали индексът е валиден
        //проверка дали индексът не е в началото - 0 до средния индекс, няма да проверяваме целия списък, само първата или втората част
        int result =0; // лелемт на дадения индекс
        checkValidIndex(index);
        if(index<=this.size/2){
            Node currentNode = this.head;
            for (int i = 0; i < index; i++) {
            currentNode=currentNode.next;
            }
            result=currentNode.currentValue; //елементът на дадения индекс

        }
        else {
            Node currentNode = this.tail;
            for (int i = size - 1; i > index ; i--) {
            currentNode = currentNode.prev;
            }
            result=currentNode.currentValue; //елементът на дадения индекс
        }
        return result;
    }
    public int removeFirst(){

        if(isEmpty()){
            throw new IllegalStateException("Error while remove element from empty list");
        }
        else if (this.size==1){
            int result = this.head.currentValue;
            this.head=this.tail=null;
            this.size--;
            return result;
        }
        else {
            int removedElement = this.head.currentValue;
            this.head=this.head.next;
            this.head.prev=null;
            this.size--;
            return removedElement;
        }
    }
    public int removeLast (){
        if(isEmpty()){
            throw new IllegalStateException("Error while remove element from empty list");
        }
        else if (this.size==1){
            int result = this.head.currentValue;
            this.head=this.tail=null;
            this.size--;
            return result;
        }
        else {
            int removedElement = this.tail.currentValue;
            this.tail=this.tail.prev;
            this.tail.next=null;
            this.size--;
            return removedElement;
        }
    }
    public void forEach (Consumer<Integer>consumer){
        Node currentNode = this.head;
        while (currentNode!=null){
        consumer.accept(currentNode.currentValue);
        currentNode=currentNode.next;
        }
    }
    public int[] toArray (){
        List<Integer>resultList = new ArrayList<>();
        forEach(el->resultList.add(el));

        return resultList.stream().mapToInt(e->e).toArray();
    }

    private void checkValidIndex(int index) {
        if (index < 0 || index>=size) {
            throw new IndexOutOfBoundsException("The index "  + index + " is out of bounds");
        }
    }


    public boolean isEmpty (){
        return this.size==0;
    }


}
