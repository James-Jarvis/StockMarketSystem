public class Gen {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Connecting to socket... fingers crossed!");

        //String id;

        //Register regi = new Register("SamE");
        //Thread registerUser = new Thread(regi);
        //registerUser.start();
        //id = regi.ID;

        //Connect con = new Connect();
        //Register reg = new Register("MYUSER");

        GetStocks fetch = new GetStocks("UserID");
        //GetStocks fetch = new GetStocks("192.168.0.2", 4200, "MYUSER");

        //Thread sendThread = new Thread(con);
        Thread fetchThread = new Thread(fetch);

        fetchThread.start();

    }
}
