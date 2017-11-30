//##SINGLETON OBJECT
public class Stock {

    String StockName;
    int StockID;
    float StockValue;

    private static Stock stockObject;

    private Stock(String stockName, int stockID, float stockValue){

        StockName = stockName;
        StockID = stockID;
        StockValue = stockValue;
    }

    public static Stock createStock (String sName, int sID, float sValue) {
        if (stockObject != null)
            return stockObject;

        return new Stock (sName, sID, sValue);

    }


}
