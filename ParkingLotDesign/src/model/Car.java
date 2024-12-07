package model;

public class Car {
    private String carNumber;
    private String color;

    public Car(String carNumber,String color){
        this.carNumber = carNumber;
        this.color = color;
    }
    public String getCarNumber(){
        return this.carNumber;
    }
    public String getColor(){
        return this.color;
    }
}
