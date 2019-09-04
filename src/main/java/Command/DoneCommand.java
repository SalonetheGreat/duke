package Command;

import General.DukeException;
import General.Message;
import Tasks.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class DoneCommand extends Command {

    private int index;

    public DoneCommand(String line) throws DukeException {
        try {
            index = Integer.parseInt(line.substring(5))-1;
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "The description of a done cannot be empty.");
        } catch (NumberFormatException e) {
            throw new DukeException(Message.getOops() + "The description of a done needs to be a integer!");
        }
    }

    @Override
    public void execute(ArrayList<Task> taskList, File file) throws DukeException, FileNotFoundException {
        try {
            taskList.get(index).setDone();
        } catch (IndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "Please enter a integer that is in range!");
        }
        System.out.println(Message.getDone() + taskList.get(index));
        writeList(taskList, file);
    }
}
