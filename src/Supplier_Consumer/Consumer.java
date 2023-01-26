package Supplier_Consumer;

import java.util.Random;

public class Consumer extends Thread{
    public String name;
    private int purchasedGoods;

    public Consumer (String name) {
        this.name = name;
        this.purchasedGoods = (new Random().nextInt(5) + 2)*2;
    }
    public void goods () {
        while (!Stock.getStock().delivery1.getGoods(this,purchasedGoods)){
            try {
                Thread.sleep((new Random().nextInt(2)*1000));
            } catch (InterruptedException ex) {}
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 11; i++) {
            goods();
            try {
                Thread.sleep((new Random().nextInt(2)*1000));
            } catch (InterruptedException ex) {}
        }
    }
}
