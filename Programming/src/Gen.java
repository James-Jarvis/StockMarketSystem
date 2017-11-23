public class Gen {

    public static void main(String[] args) {
        System.out.println("Connecting to socket... fingers crossed!");

        //Connect con = new Connect();
        //Register reg = new Register("MYUSER");
        //GetStocks fetch = new GetStocks("MYUSER");
        GetStocks fetch = new GetStocks("MYUSER");

        //Thread sendThread = new Thread(con);
        //Thread registerUser = new Thread(reg);
        Thread fetchThread = new Thread(fetch);

        fetchThread.start();
    }
}
