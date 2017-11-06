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
            System.out.println(ClientSocket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("New client has connected, new thread started.");
            //System.out.println("Connected IP is: " + ClientSocket.getRemoteSocketAddress() + "\n\n");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }

    }
}
