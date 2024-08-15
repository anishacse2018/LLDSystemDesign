package model;
import java.util.*;

public class CoffeeMachine {
    private static final CoffeeMachine coffeeMachine= new CoffeeMachine();
    private final List<Coffee> coffeeMenu;
    private Map<String,Ingredients> ingredientsMap;

    private CoffeeMachine() {
        coffeeMenu = new ArrayList<>();
        ingredientsMap = new HashMap<>();
        initializeIngredients();
        initializeCoffeeMenu();
    }
    public static CoffeeMachine getInstance() {
        return coffeeMachine;
    }
    private void initializeIngredients(){
        ingredientsMap.put("Milk",new Ingredients("Milk",10));
        ingredientsMap.put("Coffee",new Ingredients("Coffee",10));
        ingredientsMap.put("Water",new Ingredients("Water",10));
    }

    private void initializeCoffeeMenu(){
        Map<Ingredients,Integer> expressoRecipe = new HashMap<>();
        expressoRecipe.put(ingredientsMap.get("Milk"),1);
        expressoRecipe.put(ingredientsMap.get("Coffee"),2);
        expressoRecipe.put(ingredientsMap.get("Water"),1);
        coffeeMenu.add(new Coffee("Expresso",40.0,expressoRecipe));

        Map<Ingredients,Integer> latteRecipe = new HashMap<>();
        latteRecipe.put(ingredientsMap.get("Milk"),2);
        latteRecipe.put(ingredientsMap.get("Coffee"),2);
        latteRecipe.put(ingredientsMap.get("Water"),1);
        coffeeMenu.add(new Coffee("Latte",50.0,latteRecipe));

        Map<Ingredients,Integer> capaccinoRecipe = new HashMap<>();
        capaccinoRecipe.put(ingredientsMap.get("Milk"),1);
        capaccinoRecipe.put(ingredientsMap.get("Coffee"),1);
        capaccinoRecipe.put(ingredientsMap.get("Water"),1);
        coffeeMenu.add(new Coffee("capaccino",30.0,capaccinoRecipe));
    }

    public Coffee selectCoffee(String orderCoffee){
       for(Coffee coffee : coffeeMenu){
           if(orderCoffee.equalsIgnoreCase(coffee.getName())){
               return coffee;
           }
       }
       return null;
    }

    public synchronized void dispenseCoffee(Coffee coffee,Payment payment){
         if(hasEnoughIngredients(coffee)){
             if(payment.getAmount()>=coffee.getPrice()){
                 updateIngredients(coffee);
                 Double change = payment.getAmount()-coffee.getPrice();
                 if(change>0){
                     System.out.println("Please find ur change: " + change);
                 }
                 System.out.println("Dispensing Coffee: "+ coffee.getName());
             }else{
                 System.out.println("Insufficient Payment done for coffee: " + coffee.getName());
             }
         }else{
             System.out.println("Not Enough Ingredients to prepare "+ coffee.getName());
         }
    }

    public  void displayMenu(){
      for(Coffee coffee: coffeeMenu){
          System.out.println("Coffee: "+coffee.getName() + "  " + "Price: " + coffee.getPrice());
      }
    }

    private boolean hasEnoughIngredients(Coffee coffee){
       for(Map.Entry<Ingredients,Integer> entry : coffee.getRecipe().entrySet()){
           Integer availableQuantity = entry.getKey().getQuantity();
           Integer requiredQuantity =  entry.getValue();
           if(availableQuantity<requiredQuantity)return false;
       }
       return true;
    }

    private void updateIngredients(Coffee coffee){
          for(Map.Entry<Ingredients,Integer> entry : coffee.getRecipe().entrySet()){
              Ingredients ingredients = entry.getKey();
              int requiredQuantity =  entry.getValue();
              ingredients.updateQuantity(-requiredQuantity);
              if(ingredients.getQuantity()<2){
                  System.out.println("We are low on inventory" + ingredients.getName());
              }
          }
    }
}
