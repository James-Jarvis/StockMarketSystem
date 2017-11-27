import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class Connect extends Thread {

    int port;
    String hostname;

    public Connect () {
        hostname = "localhost";
        port = 4200;
    }

    public void run () {

        try {
            Socket ClientSocket;
            //connects to the socket
            ClientSocket = new Socket(hostname, port);
            System.out.println("Connected to server (send).");
            System.out.println(ClientSocket.getRemoteSocketAddress());

            //sets up the 'send' Printwriter and 'reive' BufferedReader
            PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));

            //send aknowledge command
            out.println("HELO");

            //end stream
            out.println("EXIT");

            //gets the return from the socket
            String userInput;
            while ((userInput = in.readLine()) != null) {
                //out.println(userInput);

                System.out.println("echo: " + userInput);

            }

            //done
            System.out.println("s--");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }

    }

}
