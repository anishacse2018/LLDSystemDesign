import model.Road;
import model.TrafficLight;

public class TrafficSignalSystemDemo {

    public static void run(){
        TrafficController trafficController = TrafficController.getTrafficController();
        Road road1  = new Road("Road 1","R1");
        Road road2 = new Road("Road 2","R2");
        Road road3 = new Road("Road 3","R3");
        Road road4 = new Road("Road 4","R4");

        TrafficLight trafficLight1 = new TrafficLight("TL1", 6000, 3000, 9000);
        TrafficLight trafficLight2 = new TrafficLight("TL2", 6000, 3000, 9000);
        TrafficLight trafficLight3 = new TrafficLight("TL3", 6000, 3000, 9000);
        TrafficLight trafficLight4 = new TrafficLight("TL4", 6000, 3000, 9000);

        road1.setTrafficLight(trafficLight1);
        road2.setTrafficLight(trafficLight2);
        road3.setTrafficLight(trafficLight3);
        road4.setTrafficLight(trafficLight4);

        trafficController.addRoad(road1);
        trafficController.addRoad(road2);
        trafficController.addRoad(road3);
        trafficController.addRoad(road4);

        trafficController.startTrafficControl();
        trafficController.handleEmergency("R2");
    }
}
