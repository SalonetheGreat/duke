package Command;

import General.DukeException;
import General.Message;
import Tasks.Deadline;
import Tasks.Event;
import Tasks.Task;
import Tasks.Todo;

import java.util.ArrayList;
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
    public void execute(ArrayList<Task> taskList) throws DukeException {
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
    }
}
