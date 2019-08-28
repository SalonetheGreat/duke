import java.util.ArrayList;

public class Task {
    private String name;
    private boolean isDone;

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
}
