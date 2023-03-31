package _12_DefiningClasses_Ex._3_SpeedRacing;

public class Car {

    private String model;
    private double fuelAmount;
    private double fuelCost;
    private double distancedTravelled;


    public Car(String model, double fuelAmount, double fuelCost) {
        //AudiA4 23 0.3 -> {Model} {FuelAmount} {FuelCostFor1km}", all cars start at 0 kilometers traveled
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distancedTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }
    public double getDistancedTravelled() {
        return distancedTravelled;
    }
    public void drive(double distance) {
        double fuel = distance * this.fuelCost;
        if (fuel <= this.fuelAmount) {
            this.fuelAmount -= fuel;
            this.distancedTravelled += distance;
        } else {
            System.out.println("Insufficient fuel for the drive");
        }
    }

    public String toString() {
        return String.format("%s %.2f %.0f", this.getModel(), getFuelAmount(), getDistancedTravelled());


    }


}
