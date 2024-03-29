package E1_Java_Advanced_Exam_26_Oct_2019.rabbits;

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

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable() {
        this.available = false;
    }

    @Override
    public String toString() {
        return String.format("Rabbit (%s): %s", species, name);
    }
}
