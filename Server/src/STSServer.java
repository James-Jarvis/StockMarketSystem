import java.net.*;
import java.io.*;

public class STSServer 
{

    int port = 4200;

    protected ServerSocket STSSocket = null;
    public StockMarket mySM;

    public STSServer()
    {
    }

    public void initSTS()
    {
        System.out.println("StockMarket thread started.");
        Thread t1 = new Thread(mySM.getStockMarket());
        t1.start();
    }


    public void listenForClients()
    {
        try
        {
            STSSocket = new ServerSocket(port);
            System.out.println("local IP: " + STSSocket.getChannel());

            while(true)
            {
                System.out.println("Listening for connections from Client.\n");
                new ClientConnect(STSSocket.accept(), mySM.getStockMarket());
            }
        }
        catch(IOException e)
        {
            System.out.println("Error in setting up socket " + e);
            System.exit(1);
        }
    }

    public static void main(String [] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        STSServer mySTS = new STSServer();
        mySTS.initSTS();
        mySTS.listenForClients();
    }
}