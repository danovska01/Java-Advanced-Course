package _11_DefiningClasses._1_CarInfo;

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
            String model = tokens[1];
            int hp = Integer.parseInt(tokens[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(hp);
            cars.add(car);

        }


        cars.forEach(car -> System.out.println(car.carInfo()));
    }


}
