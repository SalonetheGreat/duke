package Command;

import Command.Command;
import General.Message;
import Tasks.Task;

import java.util.ArrayList;

public class ByeCommand extends Command {
    @Override
    public void execute(ArrayList<Task> taskList) {
        System.out.println(Message.getBye());
        System.exit(0);
    }
}
