package Command;

import General.DukeException;
import General.Storage;
import Tasks.Task;
import Tasks.TaskList;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public abstract class Command {
    public abstract void execute (TaskList taskList, Storage storage) throws DukeException, FileNotFoundException;

    protected void writeList (TaskList taskList, Storage storage) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(storage.getFile());
        for (int i = 0; i < taskList.size(); i++) {
            Task thisTask = taskList.get(i);
            pw.print(thisTask.getOnlyTaskTypeIcon() + " | " + thisTask.getOnlyStatusIcon() + " | " + thisTask.getName());
            if (thisTask.getOnlyTaskTypeIcon().equals("T"))
                pw.println("");
            else
                pw.println(" | "  + thisTask.getDue());
        }
        pw.close();
    }
}
