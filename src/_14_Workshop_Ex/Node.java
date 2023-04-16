package _14_Workshop_Ex;

public class Node { // всеки елемент от нашия свързан списък е нод
    //текуща целочислена стойност
    public int currentValue;
    //следващ елемент
    public Node next;
    //предишния елемент
    public Node prev;

    //конструктор - създава еелемент по текуща стойност
    public Node(int currentValue) {
        this.currentValue = currentValue;

    }

    @Override
    public String toString (){
        return  this.currentValue + "";
    }


}
