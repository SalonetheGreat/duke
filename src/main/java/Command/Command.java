package Command;

import General.DukeException;
import General.Storage;
import General.Ui;
import Tasks.Task;
import Tasks.TaskList;

import java.io.FileNotFoundException;

/**
 * Abstract class representing some commands to be execute.
 * <p>
 * Include 6 child classes:
 * <ul>
 *     <li>AddCommand</li>
 *     <li>DeleteCommand</li>
 *     <li>DoneCommand</li>
 *     <li>ExitCommand</li>
 *     <li>FindCommand</li>
 *     <li>ListCommand</li>
 * </ul>
 */
public abstract class Command {
    private boolean exit = false;

    /**
     * To be implemented in Child classes
     * @param taskList The container for task
     * @param ui UI dealing with user IO
     * @param storage Storage to print message into
     * @throws DukeException If fail to create new task or write list into storage
     * @throws FileNotFoundException If fail to find the file
     */
    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException, FileNotFoundException;

    /**
     * Write a list into the Storage file
     * @param taskList The <code>TaskList</code> to be printed
     * @param storage The storage to accept the TaskList
     * @throws FileNotFoundException If fail to find the file
     */
    protected void writeList (TaskList taskList, Storage storage) throws FileNotFoundException {
        storage.openPW();
        for (int i = 0; i < taskList.size(); i++) {
            Task thisTask = taskList.get(i);
            storage.print(thisTask.getOnlyTaskTypeIcon() + " | " + thisTask.getOnlyStatusIcon() + " | " + thisTask.getName());
            if (thisTask.getOnlyTaskTypeIcon().equals("T"))
                storage.println("");
            else
                storage.println(" | "  + thisTask.getDue());
        }
        storage.closePW();
    }

    /**
     * Get Exit status
     * @return Exit status
     */
    public boolean isExit() {
        return exit;
    }

    /**
     * Set exit to true
     */
    protected void setExit() {
        exit = true;
    }
}
