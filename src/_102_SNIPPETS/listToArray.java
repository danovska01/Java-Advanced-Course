package _102_SNIPPETS;

import java.util.Arrays;
import java.util.List;

public class listToArray {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(54, 234, 64, 23);
        Integer[] array = list.toArray(new Integer[0]);
        for(Integer i:array) {
            System.out.println(i);
        }
    }
}
