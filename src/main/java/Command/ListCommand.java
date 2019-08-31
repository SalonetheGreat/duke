package Command;

import Command.Command;
import General.Message;
import Tasks.Task;

import javax.swing.*;
import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(ArrayList<Task> taskList) {
        System.out.println(Message.getList());
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i+1) + ". " + taskList.get(i));
        }
    }
}
