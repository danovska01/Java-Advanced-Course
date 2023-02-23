package _07_StreamsFilesAndDirectories;

import java.io.*;

public class _09_SerializeCustomObject {
    private static Object cube;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Create a class called "Cube". It should have properties for color, width, height, and depth.
        //Create an instance of the class with the following values:
        //    • Color: "green"
        //    • Width: 15.3
        //    • Height: 12.4
        //    • Depth: 3.0
        // Serialize and deserialize the instance created. When saved to a file the object should look like something like the example below.

        String path = "/home/kristina/IdeaProjects/Java-Advanced/src/_07_StreamsFilesAndDirectories/outputTask9.ser";
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);
        ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(path));
            oos.writeObject(cube);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            Cube cubeFromFile = (Cube) ois.readObject();
        System.out.println(cubeFromFile);



    }
     
}


