package rabbits;

public class Rabbit {


    private String name;
    private String species;
    private boolean available;

    public Rabbit(String name, String species) {
        this.name = name;
        this.species = species;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
 @Override
 //"Rabbit ({species}): {name}"
 public String toString() {
     StringBuilder sb = new StringBuilder();
     sb.append("Rabbit ").append(this.species).append(": ").append(this.name).append(System.lineSeparator());
     return sb.toString();
 }


}
