package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * An AddCommand means adding some task in a TaskList
 */
public class AddCommand extends Command {
    Task tbAdd;
    Scanner sc;
    String line;

    /**
     * The only constructor for AddCommand.
     * @param line The line to be parsed to task
     */
    public AddCommand (String line) {
        sc = new Scanner(line);
        this.line = line;
    }

    /**
     * Parse the string to a task, and then create a new <code>Task</code> object accordingly
     * @param taskList The container where the Task object is to be added
     * @param ui UI dealing with user IO
     * @param storage The Storage to print message into
     * @throws DukeException If fail to create new task or write list into storage
     * @throws FileNotFoundException If fail to find the file
     */
    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException, FileNotFoundException {
        String taskType = sc.next();
        switch (taskType) {
            case "todo":
                tbAdd = new Todo(line);
                break;
            case "deadline":
                tbAdd = new Deadline(line);
                break;
            case "event":
                tbAdd = new Event(line);
                break;
            default:
                System.exit(1);
        }
        taskList.add(tbAdd);
        ui.showMessageLn(Message.getAdd(tbAdd.toString()));
        writeList(taskList, storage);
    }
}
