package _12_DefiningClasses_Ex._5_CarSalesman;

public class Engine {
    //model, power, displacement, and efficiency
    String model;
    int power;
    int displacement;
    String efficiency;


    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }



    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
    }


    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
    }



    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.model).append(":\n").append("Power: " + this.power + "\n");
        if(displacement==0){
            sb.append("Displacement: ").append("n/a").append("\n");
        }
        else {
            sb.append("Displacement: ").append(this.displacement).append("\n");
        }
        if (efficiency==null){
            sb.append("Efficiency: ").append("n/a").append("\n");
        }
        else {
            sb.append("Efficiency: ").append(this.efficiency).append("\n");
        }
       return sb.toString();
    }


}
