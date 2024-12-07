package commands;

import service.ParkingService;
import java.util.Map;
import java.util.HashMap;

public class CommandExecutorFactory {

    private Map<String, CommandExecutor> commands = new HashMap<>();
    public CommandExecutorFactory(ParkingService parkingService){
        commands.put(CreateParkingLotCommandExecutor.COMMAND_NAME,  new CreateParkingLotCommandExecutor(parkingService);
    }
}
