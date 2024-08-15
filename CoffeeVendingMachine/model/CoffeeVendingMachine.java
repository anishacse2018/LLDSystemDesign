package model;
/*
https://github.com/ashishps1/awesome-low-level-design/blob/main/problems/coffee-vending-machine.md
 */
public class CoffeeVendingMachine {

    public static  void run(){
        CoffeeMachine coffeeMachine = CoffeeMachine.getInstance();

        coffeeMachine.displayMenu();
        Coffee expresso = coffeeMachine.selectCoffee("Expresso");
        coffeeMachine.dispenseCoffee(expresso,new Payment(40.0));

        Coffee latte = coffeeMachine.selectCoffee("latte");
        coffeeMachine.dispenseCoffee(latte,new Payment(10.0));

        Coffee capaccino = coffeeMachine.selectCoffee("capaccino");
        coffeeMachine.dispenseCoffee(capaccino,new Payment(90.0));
    }

}
