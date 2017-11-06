import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.Buffer;

public class Receive extends Thread {

    public void run() {
        try {
            Socket ClientSocket;
            ClientSocket = new Socket("localhost", 5000);
            System.out.println("Connected to server. (receive)");
            System.out.println(ClientSocket.getRemoteSocketAddress());

            //BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));

            String response = in.readLine();

            while (true) {
                if(response!=null) {
                    response = in.readLine();

                    System.out.print(response);
                    break;
                }
                else{
                    System.out.print("Null response");
                }
            }

            System.out.println("r--");

        } catch(IOException e){
            System.out.println("***********Problem with socket: " + e);
        }

    }



}
