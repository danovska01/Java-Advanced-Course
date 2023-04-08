package _15_Gererics._4_ListUtilities;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    //Create a class ListUtils that you will use through several other exercises:
    //The class should have two static methods:
    //    • T getMin(List<T> list)
    //    • T getMax(List<T> list)

    private ListUtils() {

    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.max(list);
    }

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("Empty list!");
        }
        return Collections.min(list);
    }

}
