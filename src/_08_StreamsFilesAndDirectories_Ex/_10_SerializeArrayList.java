package _08_StreamsFilesAndDirectories_Ex;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class _10_SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<Double> arrayList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("How many numbers you will put in the list?");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println("Start putting them?");
        for (int i = 1; i <= n; i++) {
            double num = Double.parseDouble(scanner.nextLine());
            arrayList.add(num);

        }
        String path = "/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/list.ser";

        ObjectOutputStream writer = new ObjectOutputStream (new FileOutputStream(path));
        writer.writeObject(arrayList);


      ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path));

      List<Double> array = (List) reader.readObject();
        System.out.println("Your numbers are:");

            for (Double num : array) {
                System.out.printf("%.2f%n", num);
            }


    }

}
