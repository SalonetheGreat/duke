package Command;

import Command.Command;

import java.util.ArrayList;

public class ListCommand extends Command {
    @Override
    public void execute(ArrayList<String> taskList) {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i+1) + ". " + taskList.get(i));
        }
    }
}
