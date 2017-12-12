import java.util.*;
import java.lang.*;
import java.io.*;
import java.net.*;

public class GetStocks extends Thread {


    int port;
    String hostname;
    String userID;
    boolean successful;
    boolean running = false;
    String[][] stocksIndex = new String[10][3];

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
        port = 5000;
        userID = username;
    }

    public void run(){
        running = true;
        try {
            Socket ClientSocket;
            //connects to the socket
            ClientSocket = new Socket(hostname, port);
            System.out.println("Connected to server (send).");
            System.out.println(ClientSocket.getRemoteSocketAddress());

            //sets up the 'send' Printwriter and 'receive' BufferedReader
            PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));

            //send aknowledge command
            out.println("HELO");

            //send the command you need
            out.println("REGI");
            //gets the return from the socket
            String userInput;
            while ((userInput = in.readLine()) != null) {
                //out.println(userInput);
                System.out.println("echo: " + userInput);
                if(userInput.startsWith("REGI:SUCCESS")){
                    System.out.println("Registered user " + userID + " successfully.");
                    successful = true;
                    userID = "";
                    userID = (userInput.split(":")[2]);
                    System.out.println("ID... " + userID);
                }
                if (successful == true){
                    break;
                }
            }

            out.println("DISP:" + userID);

            //end stream
            out.println("EXIT");

            //gets the return from the socket
            //String userInput;
            int counter = 0;
            while ((userInput = in.readLine()) != null) {
                //out.println(userInput);
                System.out.println("echo: " + userInput);

                if (userInput.startsWith("STK") && counter < 10) {

                    String[] chunks = userInput.split(":");
                    stocksIndex[counter][0] = chunks[1];
                    stocksIndex[counter][1] = chunks[2];
                    stocksIndex[counter][2] = chunks[3];

                    counter++;
                }

            }

            //done
            System.out.println("s--");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }
        running = false;
    }
}
