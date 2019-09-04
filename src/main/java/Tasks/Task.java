package Tasks;

import General.DukeException;

import java.util.Date;
import java.util.Scanner;

public abstract class Task {
    protected String name;
    protected boolean isDone;
    protected Scanner lineOfInput;
    protected Date due;
    protected String info;

    public Task(String line) throws DukeException {
        isDone = false;
        lineOfInput = new Scanner(line);
        lineOfInput.next();
    }

    protected final String getStatusIcon(){
        return "[" + (isDone ? "\u2713" : "\u2718") + "]";
    }
    public final String getOnlyStatusIcon() {
        return (isDone ? "1" : "0");
    }

    public String getName() {
        return name;
    }

    public String getDue() {
        return due.toString();
    }

    public abstract void setDue(String line) throws DukeException;

    public final void setDone() {
        isDone = true;
    }
    public abstract String getTaskTypeIcon();
    public abstract String getOnlyTaskTypeIcon();

    @Override
    public abstract String toString();
}
