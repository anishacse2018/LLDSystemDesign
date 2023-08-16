package NullObjectPattern;

public class Main {
    public static void main(String args[]){
        VehicleFactory vf = new VehicleFactory();
        Vehicle car = vf.getVehicleObject("Car");
        Vehicle bike = vf.getVehicleObject("Bike");
        System.out.println(car.getTankCapacity());
        System.out.println(car.getSeatingCapacity());
        System.out.println(bike.getTankCapacity());
        System.out.println(bike.getSeatingCapacity());
    }
}
