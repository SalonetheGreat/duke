package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.Task;
import Tasks.TaskList;

import java.io.FileNotFoundException;

/**
 * The DeleteCommand delete a task from the TaskLit
 */
public class DeleteCommand extends Command {

    private int index;

    /**
     * The only constructor for DeleteCommand
     * @param line The line to be parsed to the index of the task
     * @throws DukeException If fail to input format is incorrect
     */
    public DeleteCommand(String line) throws DukeException {
        try {
            index = Integer.parseInt(line.substring(7))-1;
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "The description of a delete cannot be empty.");
        } catch (NumberFormatException e) {
            throw new DukeException(Message.getOops() + "The description of a delete needs to be a integer!");
        }
    }

    /**
     *
     * @param taskList The container for task
     * @param ui UI dealing with user IO
     * @param file The file to write message
     * @throws DukeException If input integer is not in range or fail to write list
     * @throws FileNotFoundException If fail to find the file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage file) throws DukeException, FileNotFoundException {
        Task task;
        try {
            task = taskList.get(index);
            taskList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "Please enter a integer that is in range!");
        }
        ui.showMessageLn(Message.getDelete1() + task);
        ui.showMessageLn(Message.getDelete2(index));
        writeList(taskList, file);
    }
}
