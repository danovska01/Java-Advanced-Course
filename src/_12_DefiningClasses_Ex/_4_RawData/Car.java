package _12_DefiningClasses_Ex._4_RawData;

import java.util.Arrays;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tiers;


    //"{Model} {EngineSpeed} {EnginePower} {CargoWeight} {CargoType} {Tire1Pressure} {Tire1Age}
    // {Tire2Pressure} {Tire2Age} {Tire3Pressure} {Tire]’3Age} {Tire4Pressure} {Tire4Age}"
    public Car(String[] parameters) {
        this.model = parameters[0]; //{Model}
        this.setEngine(parameters);
        this.setCargo(parameters);
        this.setTiers(parameters);
    }



    public void setEngine(String[] parameters) {
        int speed = Integer.parseInt(parameters[1]); //{EngineSpeed}
        int power = Integer.parseInt(parameters[2]); //{EnginePower}
        this.engine = new Engine(speed, power);
    }

    public void setCargo(String[] parameters) {
        int weight = Integer.parseInt(parameters[3]); //{CargoWeight}
        String type = parameters[4]; //{CargoType}
        this.cargo = new Cargo(weight, type);
    }

    public void setTiers(String[] parameters) {
        this.tiers = new Tire[4];
        for (int i = 5, j = 0; i < parameters.length; i += 2, j++) {
            double pressure = Double.parseDouble(parameters[i]);
            int age = Integer.parseInt(parameters[i + 1]);
            this.tiers[j] = new Tire(age, pressure);
        }
    }

    public boolean isValidTierPressure() {
        return Arrays.stream(this.tiers).anyMatch(tier -> tier.getPressure() < 1);
    }

    public boolean isValidEnginePower() {
        return this.engine.getPower() > 250;
    }

    public String getCargoType() {
        return this.cargo.getType();
    }

    @Override
    public String toString() {
        return this.model;
    }
}
