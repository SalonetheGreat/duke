package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

/**
 * Find a task in the TaskList
 */
public class FindCommand extends Command {

    private String toFind;

    /**
     * The only constructor in FindCommand
     * @param line The string to be parsed
     * @throws DukeException If the find body is empty
     */
    public FindCommand(String line) throws DukeException {
        try {
            toFind = line.substring(5);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "The description of a find cannot be empty.");
        }
    }

    /**
     * Find and show the task
     * @param taskList The container for task
     * @param ui UI dealing with user IO
     * @param storage Storage to print message into
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showMessageLn(Message.getFind());
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getName().contains(toFind))
                ui.showMessageLn((i+1) + ". " + taskList.get(i));
        }
    }
}
