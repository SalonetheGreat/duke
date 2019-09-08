package Command;

import General.DukeException;
import General.Storage;
import General.Ui;
import Tasks.Task;
import Tasks.TaskList;

import java.io.FileNotFoundException;

public abstract class Command {
    private boolean exit = false;

    public abstract void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException, FileNotFoundException;

    protected void writeList (TaskList taskList, Storage storage) throws FileNotFoundException {
        storage.openPW();
        for (int i = 0; i < taskList.size(); i++) {
            Task thisTask = taskList.get(i);
            storage.print(thisTask.getOnlyTaskTypeIcon() + " | " + thisTask.getOnlyStatusIcon() + " | " + thisTask.getName());
            if (thisTask.getOnlyTaskTypeIcon().equals("T"))
                storage.println("");
            else
                storage.println(" | "  + thisTask.getDue());
        }
        storage.closePW();
    }

    public boolean isExit() {
        return exit;
    }

    protected void setExit() {
        exit = true;
    }
}
