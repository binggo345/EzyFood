package com.example.ezyfood_edrick;

public class databaseOrder extends database{
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public databaseOrder(String name, int price, int image, int quantity) {
        super(name, price, image);
        this.quantity = quantity;
    }
}
