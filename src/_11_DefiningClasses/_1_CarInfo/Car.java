package _11_DefiningClasses._1_CarInfo;

public class Car {
    private String brand;

    public Car() {
        this.brand = brand;
        this.model = model;
        this.horsePower = horsePower;
    }

    private String model;
    private int horsePower;

    public String getBrand (){
        return this.brand;
    }
    public void setBrand (String brand){
        this.brand= brand;
    }
    public String getModel (){
        return this.model;
    }
    public  void setModel(String model){
        this.model= model;
    }
    public int getHorsePower(){
        return this.horsePower;
    }
    public void setHorsePower(int horsePower){
        this.horsePower=horsePower;
    }
    public String carInfo () {
        return String.format("The car is: %s %s - %d HP.", this.getBrand(), this.getModel(), this.getHorsePower());
    }



}
