package model;

public class Ingredients {
    private final String name;
    private int quantity;

    Ingredients(String name, int quantity){
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }
    public int getQuantity(){
        return quantity;
    }

    public synchronized  void updateQuantity(int quantity){
        this.quantity +=quantity;
    }
}
