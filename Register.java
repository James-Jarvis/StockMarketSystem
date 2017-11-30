import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class Register extends Thread {

    int port;
    String hostname;
    String userID;
    boolean successful;
    int ID;

    boolean finished;

    public Register (String ip, int newPort, String username) {
        // Constructor
        port = newPort;
        hostname = ip;
        userID = username;
        successful = false;
    }
    public Register (String username){
        port = 5000;
        hostname = "localhost";
        userID = username;
        successful = false;
    }

    public void run () {
        finished = false;
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
            out.println(userID);

            //end stream
            out.println("EXIT");

            //gets the return from the socket
            String userInput;
            while ((userInput = in.readLine()) != null) {
                //out.println(userInput);
                System.out.println("echo: " + userInput);
                if(userInput.startsWith("REGI:SUCCESS")){
                    System.out.println("Registered user "+userID+" successfully.");
                    successful = true;
                    ID = Integer.parseInt(userInput.split(":")[2]);
                    System.out.println("ID... " + ID);
                }
            }

            //done
            System.out.println("s--");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }
        finished = true;
    }

}
