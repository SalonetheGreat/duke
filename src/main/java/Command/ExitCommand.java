package Command;

import General.DukeException;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

/**
 * Exit the programme
 */
public class ExitCommand extends Command {
    /**
     * The only constructor for ExitCommand
     * @param line The line containing "bye"
     * @throws DukeException If the description of the command is not empty
     */
    public ExitCommand(String line) throws DukeException {
        if (!line.equals("bye")) {
            throw new DukeException("☹ OOPS!!! The description of a bye need to be empty");
        }
    }

    /**
     * Print the exit message and exit the programme
     * @param taskList The container for task
     * @param ui UI dealing with user IO
     * @param storage Storage to print message into
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        setExit();
        ui.showExit();
    }
}
