package Supplier_Consumer;

public class Result {
    public static void main(String[] args) {
        Consumer[] consumers = new Consumer[10];
        Supplier[] suppliers = new Supplier[2];
        for (int i = 0; i < 10; i++) {
            consumers[i] = new Consumer("Покупатель " + (i+1));
        }
        for (int i = 0; i < 2; i++) {
            suppliers[i] = new Supplier("Поставщик " + (i+1));
        }
        for (Consumer consumer : consumers) consumer.start();
        for (Supplier supplier : suppliers) supplier.start();
    }
}
