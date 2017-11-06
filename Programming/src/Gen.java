public class Gen {

    public static void main(String[] args) {
        System.out.println("Connecting to socket... fingers crossed!");

        Send sendCon = new Send();
        Receive receiveCon = new Receive();

        Thread sendThread = new Thread(sendCon);
        Thread recThread = new Thread(receiveCon);

        recThread.start();
        sendThread.start();

    }
}
