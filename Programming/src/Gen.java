public class Gen {

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        HelloWorld hw1 = new HelloWorld(1);
        HelloWorld hw2 = new HelloWorld(2);

        Thread t1 = new Thread(hw1);
        Thread t2 = new Thread(hw2);

        t1.start();
        t2.start();

        System.out.println("end");
    }
}
