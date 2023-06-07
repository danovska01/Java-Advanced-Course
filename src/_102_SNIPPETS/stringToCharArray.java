package _102_SNIPPETS;

public class stringToCharArray {
    public static void main(String[] args) {
        String text = "Hey there";
        // Convert string to char array
        char[] array = text.toCharArray();
        for(char c: array){
            System.out.println(c);
        }
    }
}
