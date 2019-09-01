package Command;

import General.DukeException;
import General.Message;
import Tasks.Task;

import java.io.File;
import java.util.ArrayList;

public class ListCommand extends Command {
    public ListCommand(String line) throws DukeException {
        if (!line.equals("list")) {
            throw new DukeException("☹ OOPS!!! The description of a list need to be empty.");
        }
    }
    @Override
    public void execute(ArrayList<Task> taskList, File file) {
        System.out.println(Message.getList());
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i+1) + ". " + taskList.get(i));
        }
    }
}
