package Tasks;

import java.util.Scanner;

public class Todo extends Task {
    private String name;
    public Todo(String line) {
        super(line);
        due = "";
        name = info;
    }

    @Override
    public String getTaskTypeIcon() {
        return "[T]";
    }

    @Override
    public String toString() {
        return getTaskTypeIcon() + getStatusIcon() + name;
    }
}
