package Supplier_Consumer;

import java.util.Random;

public class Supplier extends Thread{
    public String name;
    private int goods;
    public static Boolean alive = true;

    public static Boolean getAlive() {
        return alive;
    }
    public Supplier(String name) {
        this.name = name;
        this.goods = (new Random().nextInt(3)+1)*10;
    }

    public void delivering() {
        while (!Stock.getStock().delivery1.addGoods(this,goods)) {
            try {
                Thread.sleep((new Random().nextInt(2)*1000));
            } catch (InterruptedException ex) {}
        }
    }
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            delivering();
            try {
                Thread.sleep((new Random().nextInt(2)*1000));
            } catch (InterruptedException ex) {}
        }
        alive = false;
    }
}
