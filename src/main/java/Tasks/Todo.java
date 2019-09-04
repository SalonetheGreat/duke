package Tasks;

import General.DukeException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

public class Todo extends Task {
    private String name;
    public Todo(String line) throws DukeException {
        super(line);
        try {
            info = lineOfInput.nextLine().substring(1);
        } catch (NoSuchElementException e) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
        }
        name = info;
        setDue(info);
    }

    @Override
    public String getTaskTypeIcon() {
        return "[T]";
    }

    @Override
    public String getOnlyTaskTypeIcon() {
        return "T";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setDue(String line) {
    }

    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name;
    }
}
