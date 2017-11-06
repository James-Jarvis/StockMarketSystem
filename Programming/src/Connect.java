import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class Connect extends Thread {

    public Connect () {

    }

    public void run() {
        try {
            Socket ClientSocket;
            ClientSocket = new Socket("localhost", 5000);
            System.out.println("Connected to server.");
            System.out.println(ClientSocket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);



            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("--");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }

    }
}
