package Command;

import Command.Command;
import General.Message;

import java.util.ArrayList;

public class ByeCommand extends Command {
    @Override
    public void execute(ArrayList<String> taskList) {
        System.out.println(Message.getBye());
        System.exit(0);
    }
}
