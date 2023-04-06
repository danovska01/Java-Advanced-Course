package _15_Gererics._1_JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar =new Jar<>();

        jar.add("First biscuit");
        jar.add("Second biscuit ");
        jar.add("Third biscuit");
        jar.add("Fourth biscuit");
        jar.add("Fifth biscuit");

        System.out.println(jar.remove());
        System.out.println(jar.remove());
        System.out.println(jar.remove());
    }
}
