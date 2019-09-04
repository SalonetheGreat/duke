package Tasks;

import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        taskList = new ArrayList<>();
    }

    public Task get(int index) {
        return taskList.get(index);
    }

    public int size() {
        return taskList.size();
    }

    public void add (Task task) {
        taskList.add(task);
    }

    public void remove (int index) {
        taskList.remove(index);
    }
}
