package Tasks;

import General.DukeException;
import General.Message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Represents a deadline task.
 * A <code>Deadline</code> object includes name, done status, and due
 */
public class Deadline extends Task {
    /**
     * The only constructor for <code>Deadline</code>.
     * @param line A string to be parsed as name and due for deadline.
     * @throws DukeException If the input is not in correct format.
     */
    public Deadline(String line) throws DukeException {
        super(line);
        try {
            info = lineOfInput.nextLine().substring(1);
        } catch (NoSuchElementException e) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.");
        }
        int splitPoint = info.indexOf("/by ");
        if (splitPoint == -1){
            throw new DukeException(Message.getOops() + "There is no \"/by \" in your input!");
        }
        name = info.substring(0, splitPoint);
        setDue(info.substring(splitPoint+4));
    }

    /**
     * Parse a string to <code>Date</code> object and set it as the due of the deadline task.
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
            throw new DukeException(Message.getOops() + "Please input deadline due as \"dd/MM/yyyy HHmm\"");
        }
        due = date;
    }

    /**
     * Return a string of task type
     * @return a string of task type
     */
    @Override
    public String getTaskTypeIcon() {
        return "[D]";
    }

    /**
     * Return a letter of task type
     * @return a letter of task type
     */
    @Override
    public String getOnlyTaskTypeIcon() {
        return "D";
    }

    /**
     * Returns a string of a <code>Deadline</code> object.
     * @return a string of <code>Deadline</code> object
     */
    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name + "(by: " + due + ")";
    }
}
