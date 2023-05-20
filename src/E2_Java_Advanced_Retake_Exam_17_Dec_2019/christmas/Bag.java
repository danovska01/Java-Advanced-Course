package E2_Java_Advanced_Retake_Exam_17_Dec_2019.christmas;
import java.util.ArrayList;
import java.util.List;

public class Bag {
    private String color;

    private int capacity;
    private List<Present>data;

    public Bag(String color, int capacity) {
        this.color = color;
        this.capacity = capacity;
        this.data=new ArrayList<>();
    }
    public String getColor() {
        return color;
    }

    public int getCapacity() {
        return capacity;
    }
    public int count (){
        return data.size();
    }
    public void add (Present present){
        if (data.size() < capacity) {
            data.add(present);
        }
    }
    public boolean remove(String name) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).getName().equals(name)) {
                data.remove(i);
                return true;
            }
        }
        return false;
    }
    public Present heaviestPresent(){
        if (data.isEmpty()) {
            return null;
        }
        Present heaviest = data.get(0);
        for (Present present : data) {
            if (present.getWeight() > heaviest.getWeight()) {
                heaviest = present;
            }
        }
        return heaviest;

    }
    public Present getPresent (String name){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getName().equals(name)){
               return data.get(i);
            }
        }
        return null;

    }
    public String report() {
        StringBuilder sb = new StringBuilder();
        sb.append(color).append(" bag contains:\n");
        for (Present present : data) {
            sb.append(present).append("\n");
        }
        return sb.toString().trim();
    }






}
