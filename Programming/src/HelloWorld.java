import java.util.*;

public class HelloWorld extends Thread {

    int name;

    Random rnd = new Random();

    public HelloWorld (int nm) {
        name = nm;
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("I am Program " + name + ": " + rnd.nextInt(40));
        }
    }

}
