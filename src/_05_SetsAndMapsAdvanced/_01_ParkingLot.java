package _05_SetsAndMapsAdvanced;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class _01_ParkingLot {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        Set<String>parkingLot = new LinkedHashSet<>();

        String [] input = scanner.nextLine().split(",\\s+");
        while (!input[0].equals("END")){
        switch (input[0]){
            case "IN":
                parkingLot.add(input[1]);
                break;
            case "OUT":
                parkingLot.remove(input[1]);
                break;
        }
        input=scanner.nextLine().split(",\\s+");
        }
        if(parkingLot.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
        else {
            for (String currentCar: parkingLot){
                System.out.println(currentCar);
            }
        }
    }
}
