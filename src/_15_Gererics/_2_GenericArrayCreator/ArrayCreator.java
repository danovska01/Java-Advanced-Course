package _15_Gererics._2_GenericArrayCreator;

import java.lang.reflect.Array;

public class ArrayCreator {
    //    Create a class ArrayCreator with a method and a single overload to it:
    //    • static T[] create(int length, T item)
    //    • static T[] create(Class<T> class, int length, T item)
    public static <T> T[] create(int length, T item) {
        T[] array = (T[]) new Object[length];
        for (int i = 0; i < length; i++) {
            array[i] = item;
        }
        return array;
    }


    public static <T> T[] create(Class<T> tClass, int length, T item) {
        T[] array = (T[]) Array.newInstance(tClass, length);
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }
}
