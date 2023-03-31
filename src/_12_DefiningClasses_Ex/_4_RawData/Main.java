package _12_DefiningClasses_Ex._4_RawData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();

            getCars();

            String cargoType = scanner.nextLine();

            switch (cargoType) {
                case "fragile":
                    cars.stream()
                            .filter(car -> car.getCargoType().equals("fragile"))
                            .filter(Car::isValidTierPressure)
                            .forEach(System.out::println);
                    break;
                case "flamable":
                    cars.stream()
                            .filter(car -> car.getCargoType().equals("flamable"))
                            .filter(Car::isValidEnginePower)
                            .forEach(System.out::println);
                    break;
            }

        }

    private static void getCars() {
        int carsNumber = Integer.parseInt(scanner.nextLine());
        while (carsNumber-- > 0) {
            String[] tokens = scanner.nextLine().split(" ");
            cars.add(new Car(tokens));
        }
    }
}
