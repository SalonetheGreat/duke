package Command;

import Command.Command;
import Tasks.Task;

import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(ArrayList<Task> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i+1) + ". " + taskList.get(i));
        }
    }
}
