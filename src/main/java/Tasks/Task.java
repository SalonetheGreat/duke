package Tasks;

import General.DukeException;

import java.util.Date;
import java.util.Scanner;

/**
 * An abstract class to be implemented as Todo, Deadline, and Event.
 * Represents a task that needs to be done.
 */
public abstract class Task {
    protected String name;
    protected boolean isDone;
    protected Scanner lineOfInput;
    protected Date due;
    protected String info;

    /**
     * The common constructor for all 3 child classes.
     * @param line The input line to be parsed to task type, task name, and time
     * @throws DukeException If the line of input is not in correct format
     */
    public Task(String line) throws DukeException {
        isDone = false;
        lineOfInput = new Scanner(line);
        lineOfInput.next();
    }

    /**
     * Returns the status icon of either done or notDone.
     * @return A string of "[isDone_icon]"
     */
    protected final String getStatusIcon(){
        return "[" + (isDone ? "\u2713" : "\u2718") + "]";
    }

    /**
     * Returns the status icon in either 1 or 0.
     * @return "1" if done, or "0" if not done
     */
    public final String getOnlyStatusIcon() {
        return (isDone ? "1" : "0");
    }

    /**
     * Name of the task.
     * @return String of name of the task
     */
    public String getName() {
        return name;
    }

    /**
     * Due for the task.
     * @return A string of due for the task
     */
    public String getDue() {
        return due.toString();
    }

    /**
     * Set due for the task.
     * @param line the line to be parsed to the due of the task
     * @throws DukeException
     */
    public abstract void setDue(String line) throws DukeException;

    /**
     * Set isDone to be true.
     */
    public final void setDone() {
        isDone = true;
    }

    /**
     * Returns the task type icon.
     * @return A string of the task type icon
     */
    public abstract String getTaskTypeIcon();

    /**
     * Returns the task type icon with 1 letter.
     * @return A letter of task type
     */
    public abstract String getOnlyTaskTypeIcon();

    /**
     * Returns string of the task including info on name, done status, type, (and due).
     * @return A string of the task
     */
    @Override
    public abstract String toString();
}
