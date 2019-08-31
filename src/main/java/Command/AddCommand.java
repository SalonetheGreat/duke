package Command;

import General.Message;
import Tasks.Task;

import java.util.ArrayList;

public class AddCommand extends Command {
    Task tbAdd;
    public AddCommand (String info) {
        tbAdd = new Task(info);
    }

    @Override
    public void execute(ArrayList<Task> taskList) {
        taskList.add(tbAdd);
        System.out.println(Message.getAdd(tbAdd.toString()));
    }
}
