package Tasks;

import General.DukeException;
import General.Message;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
        setDue(info.substring(splitPoint+4));
    }

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
