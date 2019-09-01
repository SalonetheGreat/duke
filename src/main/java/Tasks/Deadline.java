package Tasks;

import General.DukeException;
import General.Message;

import java.util.NoSuchElementException;

public class Deadline extends Task {
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
        try {
            due = info.substring(splitPoint+4);
        } catch (ArrayIndexOutOfBoundsException e) {
            due = "";
        }
    }

    @Override
    public String getTaskTypeIcon() {
        return "[D]";
    }

    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name + "(by: " + due + ")";
    }
}
