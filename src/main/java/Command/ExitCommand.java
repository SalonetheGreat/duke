package Command;

import General.DukeException;
import General.Message;
import Tasks.TaskList;

import java.io.File;

public class ExitCommand extends Command {
    public ExitCommand(String line) throws DukeException {
        if (!line.equals("bye")) {
            throw new DukeException("☹ OOPS!!! The description of a bye need to be empty");
        }
    }
    @Override
    public void execute(TaskList taskList, File file) {
        System.out.println(Message.getExit());
        System.exit(0);
    }
}
