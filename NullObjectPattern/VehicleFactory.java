package NullObjectPattern;

public class VehicleFactory {
    public Vehicle getVehicleObject(String typeOfVehicle){
         if("Car".equals(typeOfVehicle)){
            return new Car();
         }
         return new NullVehicle();
    }
}
