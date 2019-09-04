package Command;

import General.DukeException;
import General.Message;
import Tasks.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DeleteCommand extends Command {

    private int index;

    public DeleteCommand(String line) throws DukeException {
        Scanner sc = new Scanner(line);
        sc.next();
        try {
            index = Integer.parseInt(sc.nextLine().substring(1))-1;
        } catch (NoSuchElementException e) {
            throw new DukeException(Message.getOops() + "The description of a delete cannot be empty.");
        } catch (NumberFormatException e) {
            throw new DukeException(Message.getOops() + "The description of a delete needs to be a integer!");
        }
    }

    @Override
    public void execute(ArrayList<Task> taskList, File file) throws DukeException, FileNotFoundException {
        Task task;
        try {
            task = taskList.get(index);
            taskList.remove(index);
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "Please enter a integer that is in range!");
        }
        System.out.println(Message.getDelete1() + task);
        System.out.println(Message.getDelete2(index));
        writeList(taskList, file);
    }
}
