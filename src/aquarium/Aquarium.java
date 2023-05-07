package aquarium;

import java.util.ArrayList;
import java.util.Collection;

public class Aquarium {

    private String name;
    private int capacity;
    private int fins;
    private Collection<Fish>fishInPool;


    public Aquarium(String name, int capacity, int fins) {
        this.name = name;
        this.capacity = capacity;
        this.fins = fins;
        this.fishInPool= new ArrayList<>();
    }


    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getFins() {
        return fins;
    }

    public int getFishInPool() {
        return fishInPool.size();
    }

    public void add (Fish fish){
        if(capacity>getFishInPool()){

            for(Fish f : fishInPool){
                if(f.getName().equals(fish.getName())){
                   break;
                }
            }
            fishInPool.add(fish);
        }
    }







}
