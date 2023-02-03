package Supplier_Consumer;

import java.util.Random;

public class GoodsDelivery{
    private int stock;
    private volatile boolean isOpen;

    public GoodsDelivery() {
        stock = new Random().nextInt(100);
        isOpen = true;
    }
    public int getStock() {
        return stock;
    }

    public synchronized boolean getGoods (Consumer consumer, int goods) {
        if(isOpen) {
            if(stock<goods){
                System.out.println(consumer.name + ": ждет " + goods + " ед. товара. На складе осталось " + getStock() + " ед. товара.");
                isOpen = false;
                if(Supplier.getAlive()==false) {
                        System.out.println("Поставщики закончили работу. Склад больше не выдает заказы.");
                        System.exit(0);
                    }
            } else {
                stock -= goods;
                System.out.println("_______" + consumer.name + ": забрал " + goods + " ед. товара со склада. На складе осталось " + getStock() + " ед. товара.");
            }
        }
        return isOpen;
    }
    public synchronized boolean addGoods(Supplier supplier, int goods) {
        stock += goods;
        System.out.println(supplier.name + " доставил " + goods + " ед. товара. На складе сейчас " + getStock() + " ед. товара.");
        isOpen = true;
        return isOpen;
    }

}
