package Exam_Prep_Ex.groomingSalon;

import java.util.ArrayList;
import java.util.Collection;

public class GroomingSalon {
    private int capacity;
    private Collection<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data= new ArrayList<>();
    }


    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public Collection<Pet> getData() {
        return data;
    }

    public void setData(Collection<Pet> data) {
        this.data = data;
    }

    public void add (Pet pet){
        if (data.size()<capacity){
            data.add(pet);
        }
    }
    public boolean remove(String name) {
        for (Pet pet : data) {
            if (pet.getName().equals(name)) {
                data.remove(pet);
                return true;
            }
        }
        return false;
    }
    public Pet getPet(String name, String owner) {
        for (Pet pet : data) {
            if (pet.getName().equals(name) && pet.getOwner().equals(owner)) {
                return pet;
            }
        }
        return null;
    }
    public int getCount() {
        return data.size();
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append("The grooming salon has the following clients:");
        for (Pet pet : data) {
            sb.append(System.lineSeparator());
            sb.append(pet.getName()).append(" ").append(pet.getOwner());
        }
        return sb.toString();
    }

}
