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

        Facade f = new Facade(3, "localhost");
        f.register("AnthonyKerr");
        f.getStocks();

        while (f.last5Stock==null) {
        }

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 3; col++) {
                System.out.print(f.last5Stock[row][col] + ", ");
            }
            System.out.println();
        }

    }
}
