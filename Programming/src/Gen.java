public class Gen {

    public static void main(String[] args) {
        System.out.println("Connecting to socket... fingers crossed!");

        Connect con = new Connect("localhost");
        Thread sendThread = new Thread(con);
        sendThread.start();





    }
}
