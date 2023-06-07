package _102_SNIPPETS;

public class reverseString {
    public static void main(String[] args) {
        String variable = "Hey there";
        String reversed = new StringBuilder(variable).reverse().toString();
        System.out.println(reversed);
    }
}
