package _12_DefiningClasses_Ex._5_CarSalesman;
import _12_DefiningClasses_Ex._5_CarSalesman.Engine;


public class Car {
    //A Car has a model, engine, weight, and color.
    //A Car's weight, color, Engine displacements, and efficiency are optional.

    String model;
    Engine engine;
    int weight;
    String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public Car (String model, Engine engine, String color, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }
    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }
    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;

    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        //If any of the optional fields have not been given print "n/a" in its place
        sb.append(this.model).append(":").append("\n").append(this.engine.toString()).append("Weight: ");
        if (this.weight==0){
            sb.append("n/a").append("\n");
        }
        else {
            sb.append(this.weight).append("\n");
        }
        sb.append("Color: ");
        if(this.color==null){
            sb.append("n/a").append("\n");
        }
        else {
            sb.append(this.color).append("\n");
        }
        return sb.toString();

    }



}
