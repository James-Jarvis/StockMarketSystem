import java.io.*;
import java.net.Socket;
import java.nio.Buffer;

public class Receive extends Thread {

    public void run() {
        try {
            Socket ClientSocket;
            ClientSocket = new Socket("localhost", 5000);
            System.out.println("Connected to server. (receive)");
            System.out.println(ClientSocket.getRemoteSocketAddress());



            //in.close();
            System.out.println("r--");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }

    }



}
