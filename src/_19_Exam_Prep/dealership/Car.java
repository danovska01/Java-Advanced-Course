package _19_Exam_Prep.dealership;

public class Car {
    public String manufacturer;
    public String model;
    public int year;

    public Car(String manufacturer, String model, int year) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.year = year;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    @Override
    //"{manufacturer} {model} ({year})"
    public String toString() {
        //return String format (%s %s...this.manufacturer, this....
        StringBuilder sb = new StringBuilder();
        sb.append(this.manufacturer).append(" ").append(this.model).append(" ").append(this.year).append(" ");
        return sb.toString();
    }


}
