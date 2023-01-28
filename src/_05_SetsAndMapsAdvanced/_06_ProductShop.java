package _05_SetsAndMapsAdvanced;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class _06_ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] tokens = scanner.nextLine().split(",\\s+");
        TreeMap<String, LinkedHashMap<String, Double>> shops = new TreeMap<>();

        while (!tokens[0].equals("Revision")){
            String shopName = tokens[0];
            String productName = tokens[1];
            Double productPrice = Double.valueOf(tokens[2]);

            LinkedHashMap<String, Double> products = new LinkedHashMap<>();

            if (shops.containsKey(shopName)) {
                products = shops.get(shopName);
            }
            products.put(productName, productPrice);
            shops.put(shopName, products);

            tokens= scanner.nextLine().split(",\\s+");
        }
        for (String shopName : shops.keySet()) {
            System.out.println(shopName + "->");
            LinkedHashMap<String, Double> products = shops.get(shopName);
            for (String productName : products.keySet()) {
                System.out.printf("Product: %s, Price: %.1f\n", productName, products.get(productName));
            }
        }

        }




    }

