package _102_SNIPPETS;

public class charToString {
    public static void main(String[] args) {

        String string1 = Character.toString('c');
        String string2 = new Character('c').toString();
        String string3 = String.valueOf('c');

        System.out.println(string1+ string2+ string3);
    }
}
