public class Facade {

    public Stock[] last5Stock;
    public String userName;

    private int port;
    private String IP;

    //CONSTRUCTOR
    public Facade (int conPort, String conIP) {
        IP = conIP;
        port = conPort;
    }

    //userName - pass in the user name you want to register
    //returns if the register was successful or not
    public boolean register (String userName) {

        Register reg = new Register(IP, port, userName);
        Thread t = new Thread(reg);

        t.run();

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





}
