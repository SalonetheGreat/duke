package Command;

import General.DukeException;
import General.Message;
import Tasks.Task;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoneCommand extends Command {
    private int index;
    public DoneCommand(String line) throws DukeException {
        Scanner sc = new Scanner(line);
        sc.next();
        try {
            index = Integer.parseInt(sc.nextLine().substring(1))-1;
        } catch (NoSuchElementException e) {
            throw new DukeException(Message.getOops() + "The description of a done cannot be empty.");
        } catch (NumberFormatException e) {
            throw new DukeException(Message.getOops() + "The description of a done needs to be a integer!");
        }
    }

    @Override
    public void execute(ArrayList<Task> taskList) throws DukeException {
        try {
            taskList.get(index).setDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "Please enter a integer that is in range!");
        }
        System.out.println(Message.getDone() + taskList.get(index));
    }
}
