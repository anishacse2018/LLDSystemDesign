package model;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    private static int MAX_CAPACITY = 100000;
    private int capacity;
    private Map<Integer, Slot> slots;

    public Integer getCapacity(){
      return this.capacity;
    }

    public ParkingLot(int capacity){
        if(capacity>MAX_CAPACITY || capacity<=0){
            throw new RuntimeException("Wrong values of Capacity");
        }
        this.capacity = capacity;
        this.slots = new HashMap<>();
    }
    public Map<Integer,Slot> getSlots(){
        return slots;
    }

    public Slot getSlot(Integer slotNumber){
        if (slotNumber > getCapacity() || slotNumber <= 0) {
            throw new RuntimeException("Invalid Slot Number");
        }
        Map<Integer, Slot> allSlots = getSlots();
        if(!allSlots.containsKey(slotNumber)){
            allSlots.put(slotNumber, new Slot(slotNumber));
        }
        return  allSlots.get(slotNumber);
    }

    public Slot park(Car car ,Integer slotNumber){
        Slot slot = getSlot(slotNumber);
        if(!slot.isSlotFree()){
            throw new RuntimeException("Slot is not available");
        }
        slot.assignCar(car);
        return slot;
    }
    public Slot makeSlotFree(Integer slotNumber){
        Slot slot =  new Slot(slotNumber);
        slot.unAssignCar();
        return slot;
    }

}
