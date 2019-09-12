package Tasks;

import General.DukeException;
import General.Message;

import java.util.NoSuchElementException;

/**
 * Represents a task without deadline.
 * A <code>Todo</code> object contains information of name and isDone
 */
public class Todo extends Task {
    private String name;

    /**
     * A constructor for class Todo.
     * @param line the input line to be parsed as name
     * @throws DukeException
     */
    public Todo(String line) throws DukeException {
        super(line);
        try {
            info = lineOfInput.nextLine().substring(1);
        } catch (NoSuchElementException e) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
        name = info;
    }

    /**
     * This function gets the function type in a String.
     * @return the task type in the form of "[T]"
     */
    @Override
    public String getTaskTypeIcon() {
        return "[T]";
    }

    /**
     * Returns the task type icon with only 1 letter.
     * @return a string: "T"
     */
    @Override
    public String getOnlyTaskTypeIcon() {
        return "T";
    }

    /**
     * Returns the name of this task.
     * @return name: string of the task name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * NULL method, just for implementation.
     * @param line: the input due
     * @throws DukeException: cannot set due for a todo
     */
    @Override
    public void setDue(String line) throws DukeException {
        throw new DukeException(Message.getOops() + "You cannot set due for a todo task.");
    }

    /**
     * Returns a string including task type, status, and name of the todo task.
     * @return the string of the todo task
     */
    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name;
    }
}
