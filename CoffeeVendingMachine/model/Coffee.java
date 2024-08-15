package model;

import java.util.Map;

public class Coffee {
    private Double price;
    private String name;
    private Map<Ingredients,Integer> recipe;

    public Coffee(String name, Double price,Map<Ingredients,Integer> recipe){
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public Double getPrice(){
        return this.price;
    }
    public String getName(){
        return this.name;
    }

    public Map<Ingredients, Integer> getRecipe() {
        return recipe;
    }
}
