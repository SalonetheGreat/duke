package Tasks;

public class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        isDone = false;
    }

    private String getStatusIcon(){
        return "[" + (isDone ? "\u2713" : "\u2718") + "]";
    }

    public void setDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return getStatusIcon() + " " + name;
    }
}
