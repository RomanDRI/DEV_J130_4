package Supplier_Consumer;

public class Stock {
    public GoodsDelivery delivery1 = new GoodsDelivery();
    private static Stock stock = new Stock();
    private Stock (){}
    public static Stock getStock(){
        return stock;
    }
}
