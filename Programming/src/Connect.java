import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class Connect extends Thread {

    public Connect () {

    }

    public void run () {

        try {
            Socket ClientSocket;
            ClientSocket = new Socket("localhost", 5000);
            System.out.println("Connected to server (send).");
            System.out.println(ClientSocket.getRemoteSocketAddress());

            PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));

            out.println("HELP");
            out.println("EXIT");

            String userInput;
            while ((userInput = in.readLine()) != null) {
                //out.println(userInput);

                System.out.println("echo: " + userInput);

            }

            System.out.println("s--");
            out.println("EXIT");


        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }

    }

}
