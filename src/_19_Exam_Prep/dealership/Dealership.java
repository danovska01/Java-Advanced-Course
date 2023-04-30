package _19_Exam_Prep.dealership;

import java.util.ArrayList;
import java.util.Collection;

public class Dealership {


    private Collection<Car>data;
    public String name;
    public int capacity;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data= new ArrayList<>();
    }

    public Collection<Car> getData() {
        return data;
    }

    public void setData(Collection<Car> data) {
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void add (Car car){
        if(this.data.size()<this.capacity){
            this.data.add(car);
        }
     ;
    }
    public boolean buy (String manufacturer, String model){
        for(Car car: this.data){
            if(car.getManufacturer().equals(manufacturer)&& car.getModel().equals(model)){
                this.data.remove(car);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar(){
        //return data.stream().max(Comparator.comparing(Car::getYear)).get();
        Car car = null;
        int latestYear= Integer.MIN_VALUE;

        for(Car currentCar: this.data){
            if(currentCar.getYear()>latestYear){
             latestYear= currentCar.getYear();
            }
        }
        return car;

    }

    public Car getCar(String manufacturer, String model){
        for(Car car: this.data){
            if(car.getManufacturer().equals(manufacturer) && car.getModel().equals(model)){
                return car;
            }
        }
        return null;

    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:%n", this.name));

        for(Car car: this.data){
            sb.append(car.toString()).append(System.lineSeparator());
        }

        return sb.toString();
    }


}
