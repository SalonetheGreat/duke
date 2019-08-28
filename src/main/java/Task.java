import java.util.ArrayList;

public abstract class Task {
    protected String name;
    protected boolean isDone;

    Task (String name) {
        this.name = name;
        isDone = false;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone() {
        isDone = true;
    }

    public String getStatusIcon() {
        return (isDone() ? "\u2713" : "\u2718");
    }

    public abstract String getClassID();
    public abstract String getTime();

    @Override
    public String toString() {
        return "[" + getStatusIcon() + "]" + name;
    }
}
