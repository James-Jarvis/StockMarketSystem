import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class GetStocks extends Thread {


    int port;
    String hostname;
    String userID;
    boolean successful;
    Stock[] stocksIndex = new Stock[10];

    public GetStocks (String ip, int newPort, String username) {
        // Constructor
        port = newPort;
        hostname = ip;
        userID = username;
        successful = false;
    }
    public GetStocks (String username){
        successful = false;
        hostname = "localhost";
        port = 4200;
        userID = username;
    }

    public void run(){
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

            //send the command you need
            out.println("REGI");
            out.println("DISP");

            //out.println("1");
            //out.println("5");

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
