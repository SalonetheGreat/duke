package Tasks;

import General.DukeException;
import General.Message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Represents a event task.
 * A <code>Event</code> object includes name, done status, and time
 */
public class Event extends Task {
    /**
     * The only constructor for <code>Event</code>.
     * @param info A string to be parsed as name and time for event.
     * @throws DukeException If the input is not in correct format.
     */
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
        setDue(info.substring(splitPoint+4));
    }

    /**
     * Parse a string to <code>Date</code> object and set it as the time of the event task.
     * @param dueString The string to be parsed.
     * @throws DukeException If the dueString is not in the format of "dd/MM/yyyy HHmm".
     */
    @Override
    public void setDue(String dueString) throws DukeException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date date;
        try {
            date = simpleDateFormat.parse(dueString);
        } catch (ParseException e) {
            throw new DukeException(Message.getOops() + "Please input event time as \"dd/MM/yyyy HHmm\"");
        }
        due = date;
    }

    /**
     * Return a string of task type
     * @return a string of task type
     */
    @Override
    public String getTaskTypeIcon() {
        return "[E]";
    }

    /**
     * Return a letter of task type
     * @return a letter of task type
     */
    @Override
    public String getOnlyTaskTypeIcon() {
        return "E";
    }

    /**
     * Returns a string of a <code>Deadline</code> object.
     * @return a string of <code>Deadline</code> object
     */
    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name + "(at: " + due + ")";
    }
}
