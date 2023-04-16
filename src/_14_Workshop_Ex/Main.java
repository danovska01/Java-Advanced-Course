package _14_Workshop_Ex;

public class Main {
    public static void main(String[] args) {

        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst(3);
        linkedList.addFirst(2);
        linkedList.addFirst(1);

        linkedList.addLast(7);
        linkedList.addLast(8);
        linkedList.addLast(9);

        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(5));

        linkedList.forEach(el-> System.out.print(el + " "));
        System.out.println();
        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList.removeLast());

        linkedList.forEach(el-> System.out.print(el + " "));
        System.out.println();

        int [] array = linkedList.toArray();
        for (int el: array){
            System.out.print(el + " ");
        }
    }

}
