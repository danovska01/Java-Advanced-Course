package _08_StreamsFilesAndDirectories_Ex;

import java.io.*;

public class _11_SerializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Write a program that saves and loads the information about a custom object using ObjectInputStream and ObjectOutputStream.
        //Create a simple class called "Course" that has a String field containing its name and an integer field containing
        // the number of students attending the course. Set the name of the save file as "course.ser".

        Course course = new Course();
        course.name = "English B2 2023";
        course.numberStudents = 100;

        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/courses.ser"));
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("/home/kristina/IdeaProjects/Java-Advanced/src/_08_StreamsFilesAndDirectories_Ex/courses.ser"));

        output.writeObject(course); //serialize -> write to file

        Course courseFromFile = (Course) input.readObject(); //deserialize, -> read from file
        System.out.println(courseFromFile.numberStudents);
        System.out.println(courseFromFile.name);

    }
}
