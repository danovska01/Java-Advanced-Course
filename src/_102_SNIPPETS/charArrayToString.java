package _102_SNIPPETS;

public class charArrayToString {
    public static void main(String[] args) {
        char[] array = {'c','o','d','i','n','g'};
        String text = new String(array);
        System.out.println(text);



        char[] array2 = {'p','r','o','g','r','a','m','m','i','n','g'};
        String text2 = String.valueOf(array2);
        System.out.println(text2);
    }
}
