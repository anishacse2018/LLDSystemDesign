package service;

import model.Car;
import model.ParkingLot;
import model.Slot;
import strategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class ParkingService {
    private ParkingStrategy parkingStrategy;
    private ParkingLot parkingLot;

    public void createParkingLot(ParkingLot parkingLot,ParkingStrategy parkingStrategy){
        if(Objects.isNull(parkingLot)){
            throw new RuntimeException("Parking Lot already exists");
        }
        this.parkingLot = parkingLot;
        this.parkingStrategy = parkingStrategy;
        for(int i=1;i<=parkingLot.getCapacity();i++){
            parkingStrategy.addSlot(i);
        }
    }

    public Integer park(final Car car){
        validateParkingLotExists();
        int slotNumber = parkingStrategy.getNextSlot();
        parkingLot.park(car,slotNumber);
        parkingStrategy.removeSlot(slotNumber);
        return slotNumber;

    }
    public void makeSlotFree(Integer slotNumber){
       validateParkingLotExists();
       parkingLot.makeSlotFree(slotNumber);
       parkingStrategy.addSlot(slotNumber);
    }

    public List<Slot> getOccupiedSlots(){
       validateParkingLotExists();
       List<Slot> occupiedSlots = new ArrayList<>();
       Map<Integer,Slot> allSlots = parkingLot.getSlots();
       for(Integer slotNumber:allSlots.keySet()){
           if(!parkingLot.getSlot(slotNumber).isSlotFree()){
               occupiedSlots.add(allSlots.get(slotNumber));
           }
       }
       return occupiedSlots;
    }

    public void validateParkingLotExists(){
       if(parkingLot==null)throw new RuntimeException("Parking Lot Does not exist");
    }

    public List<Slot> getSlotsForColor(String color){
          List<Slot> occupiedSlots = getOccupiedSlots();
          List<Slot> getSlotsForColor = new ArrayList<>();
          for(int i=0;i<occupiedSlots.size();i++){
               if(occupiedSlots.get(i).getParkedCar().getColor().equalsIgnoreCase(color)){
                   getSlotsForColor.add(occupiedSlots.get(i));
               }
          }
          return getSlotsForColor;
    }
}
