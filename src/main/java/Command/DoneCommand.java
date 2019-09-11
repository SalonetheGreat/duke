package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

import java.io.FileNotFoundException;

/**
 * Set a task as done
 */
public class DoneCommand extends Command {

    private int index;

    /**
     * The only constructor for DoneCommand
     * @param line The string to be parsed
     * @throws DukeException If the input format is incorrect
     */
    public DoneCommand(String line) throws DukeException {
        try {
            index = Integer.parseInt(line.substring(5))-1;
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "The description of a done cannot be empty.");
        } catch (NumberFormatException e) {
            throw new DukeException(Message.getOops() + "The description of a done needs to be a integer!");
        }
    }

    /**
     * Set a task to done
     * @param taskList The container for task
     * @param ui UI dealing with user IO
     * @param storage Storage to print message into
     * @throws DukeException If the integer is not in range
     * @throws FileNotFoundException If fail to find the file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException, FileNotFoundException {
        try {
            taskList.get(index).setDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "Please enter a integer that is in range!");
        }
        ui.showMessageLn(Message.getDone() + taskList.get(index));
        writeList(taskList, storage);
    }
}
