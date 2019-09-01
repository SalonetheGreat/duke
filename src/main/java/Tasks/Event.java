package Tasks;

import General.DukeException;
import General.Message;

import java.util.NoSuchElementException;

public class Event extends Task {
    public Event(String info) throws DukeException {
        super(info);
        try {
            info = lineOfInput.nextLine().substring(1);
        } catch (NoSuchElementException e) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.");
        }
        int splitPoint = info.indexOf("/at ");
        if (splitPoint == -1) {
            throw new DukeException(Message.getOops() + "There is no \"/at \" in your input!");
        }
        name = info.substring(0, splitPoint);
        try {
            due = info.substring(splitPoint + 4);
        } catch (ArrayIndexOutOfBoundsException e) {
            due = "";
        }
    }

    @Override
    public String getTaskTypeIcon() {
        return "[E]";
    }

    @Override
    public String getOnlyTaskTypeIcon() {
        return "E";
    }

    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name + "(at: " + due + ")";
    }
}
