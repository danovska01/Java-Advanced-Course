package _20_Exam_Prep_Ex.groomingSalon;

public class Pet {


    private String name;
    private int age;
    private String owner;

    public Pet(String name, int age, String owner) {
        this.name = name;
        this.age = age;
        this.owner = owner;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

 @Override
 public String toString() {
     //return String format //{name} {age} - ({owner})
     return String.format("%s %d - (%s)", this.name, this.age, this.owner);
     /*StringBuilder sb = new StringBuilder();
     sb.append(this.name).append(" ").append(this.age).append(" - ").append(this.owner).append(System.lineSeparator());
     return sb.toString();*/
 }



}
