package Tasks;

public class Deadline extends Task {
    public Deadline(String line) {
        super(line);
        int splitPoint = info.indexOf("/by ");
        name = info.substring(0, splitPoint);
        due = info.substring(splitPoint+4);
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
