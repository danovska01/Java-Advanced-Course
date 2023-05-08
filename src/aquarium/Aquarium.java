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
    public boolean remove (String name){

        for(Fish f : fishInPool){
            if(f.getName().equals(name)){
               fishInPool.remove(f);
               return true;
            }
        }
        return false;
    }

    public Fish findFish (String name){
        Fish fish = null;

        for(Fish f : fishInPool){
            if(f.getName().equals(name)){

                fish= f;
            }
        }
        return fish;
    }

    public String report (){
        StringBuilder sb = new StringBuilder();
        //"Aquarium: {name} ^ Size: {size}
        //{Fish1}
        //{Fish2}
        sb.append(String.format("Aquarium: %s ^ Size: %d%n", name, fishInPool.size() ));
        for(Fish f : fishInPool){
            sb.append(f.toString());
        }
        return sb.toString();

    }

}
