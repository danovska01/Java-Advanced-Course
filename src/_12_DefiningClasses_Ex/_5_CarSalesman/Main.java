package _12_DefiningClasses_Ex._5_CarSalesman;


import java.util.*;

public class Main {
    static Scanner scanner= new Scanner(System.in);
    static Map<String, Engine> engineMap = new LinkedHashMap<>();
    static Map<String, Car> carMap = new LinkedHashMap<>();

    public static void main(String[] args) {


        getEngines();
        getCars();

        for (Map.Entry<String, Car> entry : carMap.entrySet()) {
            System.out.print(entry.getValue().toString());
        }
        //This code will iterate over each entry in the carMap, and for each entry it will retrieve the value (which is a Car object)
        // and call its toString() method to print the car's details.



    }

    private static void getCars() {
        int m = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < m; i++) {
            //{Model} {Engine} {Weight} {Color} - FordFocus V4-33 1300 Silver
            String [] carInformation = scanner.nextLine().split("\\s+");
            String model = carInformation[0];
            String engineName = carInformation[1];
            Engine engine = engineMap.get(engineName);
            if(carInformation.length==2){
                Car car = new Car(model, engine);
                carMap.put(model, car);
            }
            if(carInformation.length==3){
                if(Character.isDigit(carInformation[2].charAt(0))){
                    int weight = Integer.parseInt(carInformation[2]);
                    Car car = new Car (model, engine, weight);
                    carMap.put(model, car);
                }
                else {
                    String color = carInformation[2];
                    Car car = new Car(model, engine, color);
                    carMap.put(model, car);
                }
            }
            if(carInformation.length==4){
                int weight = Integer.parseInt(carInformation[2]);
                String color = carInformation[3];
                Car car = new Car(model, engine, weight, color);
                carMap.put(model, car);
            }

        }
    }

    private static void getEngines() {
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String [] engineInformation= scanner.nextLine().split("\\s+");
            //{Model} {Power} {Displacement} {Efficiency} - V4-33 140 28 B
            String model = engineInformation[0];
            int power = Integer.parseInt(engineInformation[1]);
            if(engineInformation.length==2){
                Engine engine = new Engine(model, power);
                engineMap.put(model, engine);
            }
            if(engineInformation.length==3){
                if(Character.isLetter(engineInformation[2].charAt(0))){
                    String efficiency = engineInformation[2];
                    Engine engine = new Engine(model, power, efficiency);
                    engineMap.put(model, engine);
                }
                else {
                    int displacement = Integer.parseInt(engineInformation[2]);
                    Engine engine = new Engine(model, power, displacement);
                    engineMap.put(model, engine);
                }
            }

            if(engineInformation.length==4){
                int displacement = Integer.parseInt(engineInformation[2]);
                String efficiency = engineInformation[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engineMap.put(model, engine);
            }

        }

    }
}
