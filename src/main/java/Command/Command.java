package Command;

import General.DukeException;
import Tasks.Task;

import java.util.ArrayList;

public abstract class Command {
    public abstract void execute (ArrayList<Task> taskList) throws DukeException;

}
