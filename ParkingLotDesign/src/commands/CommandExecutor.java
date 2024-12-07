package commands;

import model.Command;
import service.ParkingService;

public abstract class CommandExecutor {

    private ParkingService parkingLotService;
    CommandExecutor(ParkingService parkingLotService){
        this.parkingLotService = parkingLotService;
    }

    public abstract boolean validate(Command command);
    public abstract void execute(Command command);

}
