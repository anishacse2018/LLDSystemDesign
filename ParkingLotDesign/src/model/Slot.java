package model;

public class Slot {
    private Car parkedCar;
    private Integer slotNumber;

    public Slot(Integer slotNumber){
        this.slotNumber = slotNumber;
    }
    public Integer getSlotNumber(){
        return this.slotNumber;
    }
    public Car getParkedCar(){
        return this.parkedCar;
    }
    public boolean isSlotFree(){
        return this.parkedCar == null;
    }
    public void assignCar(Car parkedCar){
         this.parkedCar = parkedCar;
    }
    public void unAssignCar(){
        this.parkedCar = null;
    }
}
