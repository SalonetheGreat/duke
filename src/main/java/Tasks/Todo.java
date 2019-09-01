package Tasks;

import General.DukeException;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Todo extends Task {
    private String name;
    public Todo(String line) throws DukeException {
        super(line);
        try {
            info = lineOfInput.nextLine().substring(1);
        } catch (NoSuchElementException e) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
        due = "";
        name = info;
    }

    @Override
    public String getTaskTypeIcon() {
        return "[T]";
    }

    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name;
    }
}
