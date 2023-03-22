package _11_DefiningClasses._2_CarInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            //Chevrolet Impala 390
            String [] tokens = scanner.nextLine().split(" ");
            String brand = tokens[0];
            if (tokens.length == 1) {
                Car car = new Car(brand);
                cars.add(car);
            } else {
                String model = tokens[1];
                int horsePower = Integer.parseInt(tokens[2]);
                Car car = new Car(brand, model, horsePower);
                cars.add(car);
            }



        }


        cars.forEach(car -> System.out.println(car.carInfo()));
    }


}
