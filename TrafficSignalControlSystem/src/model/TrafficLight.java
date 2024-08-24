package model;

public class TrafficLight {

    private String id;
    private Signal signal;
    private int redDuration;
    private int yellowDuration;
    private int greenDuration;

    public TrafficLight(String id, int redDuration, int yellowDuration, int greenDuration) {
        this.id = id;
        this.signal = Signal.RED;
        this.redDuration = redDuration;
        this.yellowDuration = yellowDuration;
        this.greenDuration = greenDuration;
    }

    public int getRedDuration() {
        return redDuration;
    }

    public void setRedDuration(int redDuration) {
        this.redDuration = redDuration;
    }

    public int getYellowDuration() {
        return yellowDuration;
    }

    public void setYellowDuration(int yellowDuration) {
        this.yellowDuration = yellowDuration;
    }

    public int getGreenDuration() {
        return greenDuration;
    }

    public void setGreenDuration(int greenDuration) {
        this.greenDuration = greenDuration;
    }

    public synchronized void changeSignal(Signal newSignal){
        this.signal = newSignal;
        notifyObservers();
    }
    private void notifyObservers(){
        System.out.println("The signal has changed to: " + signal);
    }
}
