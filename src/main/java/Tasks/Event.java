package Tasks;

public class Event extends Task {
    public Event(String info) {
        super(info);
        int splitPoint = info.indexOf("/at ");
        name = info.substring(0, splitPoint);
        due = info.substring(splitPoint+4);
    }

    @Override
    public String getTaskTypeIcon() {
        return "[E]";
    }

    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name + "(at: " + due + ")";
    }
}
