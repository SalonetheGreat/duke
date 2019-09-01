package Command;

import General.DukeException;
import General.Message;
import Tasks.Task;

import java.io.File;
import java.util.ArrayList;

public class ByeCommand extends Command {
    public ByeCommand(String line) throws DukeException {
        if (!line.equals("bye")) {
            throw new DukeException("☹ OOPS!!! The description of a bye need to be empty");
        }
    }
    @Override
    public void execute(ArrayList<Task> taskList, File file) {
        System.out.println(Message.getBye());
        System.exit(0);
    }
}
