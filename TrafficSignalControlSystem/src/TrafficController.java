import model.Road;
import model.Signal;
import model.TrafficLight;
import java.util.HashMap;
import java.util.Map;

public class TrafficController {

    private static TrafficController trafficController;
    private Map<String, Road> roads;

    private TrafficController(){
       roads = new HashMap<>();
    }

    public static TrafficController getTrafficController(){
        if(trafficController==null)return new TrafficController();
        return trafficController;
    }

    public void addRoad(Road road){
        roads.put(road.getId(), road);
    }

    public void removeRoad(String roadId){
        roads.remove(roadId);
    }

    public void startTrafficControl(){
       for(Road road:roads.values()){
           TrafficLight trafficLight = road.getTrafficLight();
           new Thread(()->{
               while(true){
                   try{
                       Thread.sleep(trafficLight.getRedDuration());
                       trafficLight.changeSignal(Signal.GREEN);
                       Thread.sleep(trafficLight.getGreenDuration());
                       trafficLight.changeSignal(Signal.YELLOW);
                       Thread.sleep(trafficLight.getYellowDuration());
                       trafficLight.changeSignal(Signal.RED);
                   }catch (InterruptedException exc){
                       exc.printStackTrace();
                   }
               }
           }).start();
       }
    }

    public void handleEmergency(String roadId){
        Road road = roads.get(roadId);
        if(road!=null){
            TrafficLight trafficLight = road.getTrafficLight();
            trafficLight.changeSignal(Signal.GREEN);
            System.out.println("Emergency Handling");
        }
    }
}
