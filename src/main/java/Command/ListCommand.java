package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

/**
 * List all the tasks in the TaskList
 */
public class ListCommand extends Command {
    /**
     * The only constructor for ListCommand
     * @param line The string containing "list"
     * @throws DukeException If the body of list is not empty
     */
    public ListCommand(String line) throws DukeException {
        if (!line.equals("list")) {
            throw new DukeException("☹ OOPS!!! The description of a list need to be empty.");
        }
    }

    /**
     * List all tasks to user
     * @param taskList The container for task
     * @param ui UI dealing with user IO
     * @param storage Storage to print message into
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showMessageLn(Message.getList());
        for (int i = 0; i < taskList.size(); i++) {
            ui.showMessageLn((i+1) + ". " + taskList.get(i));
        }
    }
}
