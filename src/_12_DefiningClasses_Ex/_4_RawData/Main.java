package _12_DefiningClasses_Ex._4_RawData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        int carsNumber = Integer.parseInt(scanner.nextLine());
        while (carsNumber-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            cars.add(new Car(tokens));
        }

            String cargoType = scanner.nextLine();

            switch (cargoType) {
                case "fragile":
                    //"fragile" print all cars whose Cargo Type is "fragile" with a tire whose pressure is  < 1
                    cars.stream()
                            .filter(car -> car.getCargoType().equals("fragile"))
                            .filter(Car::isValidTierPressure)
                            .forEach(System.out::println);
                    break;
                case "flamable":
                    //"flamable" print all cars whose Cargo Type is "flamable" and have Engine Power > 250.
                    cars.stream()
                            .filter(car -> car.getCargoType().equals("flamable"))
                            .filter(Car::isValidEnginePower)
                            .forEach(System.out::println);
                    break;
            }

        }
}
