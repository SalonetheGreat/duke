package Command;

import General.DukeException;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

public class ExitCommand extends Command {
    public ExitCommand(String line) throws DukeException {
        if (!line.equals("bye")) {
            throw new DukeException("☹ OOPS!!! The description of a bye need to be empty");
        }
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        setExit();
        ui.showExit();
    }
}
