import sun.awt.TracedEventQueue;

public class Facade {

    public String[][] last5Stock;
    public String userName;

    private int port;
    private String IP;

    boolean running;

    //CONSTRUCTOR
    public Facade (int conPort, String conIP) {
        IP = conIP;
        port = conPort;
        running = false;
    }

    //userName - pass in the user name you want to register
    //returns if the register was successful or not
    public boolean register (String userName) {
        running = true;

        Register reg = new Register(IP, port, userName);
        Thread t = new Thread(reg);

        t.run();

        running = false;
        return reg.successful;

    }

    //returns an array with the past 5 stock values in it
    public void updateStocks () {
        //registers user and gets their ID for this connection
        Register reg = new Register(IP, port, userName);
        Thread t = new Thread(reg);

        t.run();

        //waits for the register thread to finish running
        while (!reg.finished) {
            //wait
        }

        int id = reg.ID;


        //makes get stock class
        GetStocks gs = new GetStocks(IP, port, Integer.toString(id));
        t = new Thread(gs);
        t.run();

        //gets the stock objects from the GetStock class
        last5Stock = gs.stocksIndex;

    }

    public String[][] getStocks () {
        running = true;
        GetStocks gs = new GetStocks(IP, port, userName);

        Thread t = new Thread(gs);
        t.run();

        while(gs.running) {

        }

        last5Stock = gs.stocksIndex;

        running = false;
        return last5Stock;
    }

}
