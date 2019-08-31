package Command;

import General.Message;
import Tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class DoneCommand extends Command {
    private int index;
    public DoneCommand(String line) {
        Scanner sc = new Scanner(line);
        sc.next();
        index = sc.nextInt()-1;
    }

    @Override
    public void execute(ArrayList<Task> taskList) {
        taskList.get(index).setDone();
        System.out.println(Message.getDone() + taskList.get(index));
    }
}
