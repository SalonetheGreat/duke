package Command;

import General.DukeException;
import Tasks.Task;
import Tasks.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public abstract class Command {
    public abstract void execute (TaskList taskList, File file) throws DukeException, FileNotFoundException;

    protected void writeList (TaskList taskList, File file) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(file);
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
