import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Register extends Thread {

    String connectionIP;

    public Register (String ip) {
        connectionIP = ip;
    }

    public void run () {

        try {
            Socket ClientSocket;
            //connects to the socket
            ClientSocket = new Socket(connectionIP, 5000);
            System.out.println("Connected to server (send).");
            System.out.println(ClientSocket.getRemoteSocketAddress());

            //sets up the 'send' Printwriter and 'reive' BufferedReader
            PrintWriter out = new PrintWriter(ClientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));

            //send aknowledge command
            out.println("HELO");

            //send the command you need

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

