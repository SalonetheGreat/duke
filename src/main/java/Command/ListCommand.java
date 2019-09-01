package Command;

import Command.Command;
import General.DukeException;
import General.Message;
import Tasks.Task;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ListCommand extends Command {
    public ListCommand(String line) throws DukeException {
        if (!line.equals("list")) {
            throw new DukeException("☹ OOPS!!! The description of a list need to be empty.");
        }
    }
    @Override
    public void execute(ArrayList<Task> taskList) {
        System.out.println(Message.getList());
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i+1) + ". " + taskList.get(i));
        }
    }
}
