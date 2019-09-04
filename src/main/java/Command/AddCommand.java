package Command;

import General.DukeException;
import General.Message;
import Tasks.*;

import java.io.File;
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
    public void execute(TaskList taskList, File file) throws DukeException, FileNotFoundException {
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
        System.out.println(Message.getAdd(tbAdd.toString()));
        writeList(taskList, file);
    }
}
