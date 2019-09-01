package Tasks;

import General.DukeException;

import java.util.Scanner;

public abstract class Task {
    protected String name;
    protected boolean isDone;
    protected Scanner lineOfInput;
    protected String due;
    protected String info;

    public Task(String line) throws DukeException {
        isDone = false;
        lineOfInput = new Scanner(line);
        lineOfInput.next();
    }

    protected final String getStatusIcon(){
        return "[" + (isDone ? "\u2713" : "\u2718") + "]";
    }

    public final void setDone() {
        isDone = true;
    }
    public abstract String getTaskTypeIcon();

    @Override
    public abstract String toString();
}
