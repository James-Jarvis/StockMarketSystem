import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Send extends Thread{

    public void run() {
        try {
            Socket ClientSocket;
            ClientSocket = new Socket("localhost", 5000);
            System.out.println("Connected to server (send).");
            System.out.println(ClientSocket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);

            out.println("HELO");

            System.out.println("s--");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }

    }

}
