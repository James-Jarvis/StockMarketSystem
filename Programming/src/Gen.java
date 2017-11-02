public class Gen {

    public static void main(String[] args) {
        System.out.println("Connecting to socket... fingers crossed!");

        Connect conn1 = new Connect();
        Connect conn2 = new Connect();

        Thread t1 = new Thread(conn1);
        Thread t2 = new Thread(conn2);

        t1.start();
        t2.start();
    }
}
