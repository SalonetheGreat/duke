package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

public class ListCommand extends Command {
    public ListCommand(String line) throws DukeException {
        if (!line.equals("list")) {
            throw new DukeException("☹ OOPS!!! The description of a list need to be empty.");
        }
    }
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showMessageLn(Message.getList());
        for (int i = 0; i < taskList.size(); i++) {
            ui.showMessageLn((i+1) + ". " + taskList.get(i));
        }
    }
}
