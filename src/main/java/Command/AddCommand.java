package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.*;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class AddCommand extends Command {
    Task tbAdd;
    Scanner sc;
    String line;
    public AddCommand (String line) {
        sc = new Scanner(line);
        this.line = line;
    }

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
