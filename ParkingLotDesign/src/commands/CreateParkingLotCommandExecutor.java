package commands;

import model.Command;

public class CreateParkingLotCommandExecutor extends CommandExecutor{

    public static
    @Override
    public boolean validate(Command command) {
        return false;
    }

    @Override
    public void execute(Command command) {

    }
}
