package Tasks;

import java.util.ArrayList;

/**
 * A collection of <code>Task</code> objects using ArrayList
 */
public class TaskList {
    private ArrayList<Task> taskList;

    /**
     * The only constructor for TaskList.
     * Create a empty ArrayList
     */
    public TaskList() {
        taskList = new ArrayList<>();
    }

    /**
     * Returns a <code>Task</code> object at the index <i>i</i> of the TaskList.
     * @param index the index of the task in the task list
     * @return a <code>Task</code> at index <i>i</i>
     */
    public Task get(int index) {
        return taskList.get(index);
    }

    /**
     * # of tasks in a TaskList
     * @return size of the TaskList
     */
    public int size() {
        return taskList.size();
    }

    /**
     * Add a <code>Task</code> object to the end of the <code>TaskList</code>.
     * @param task The <code>Task</code> object to be added
     */
    public void add (Task task) {
        taskList.add(task);
    }

    /**
     * Remove the <code>Task</code> object at index <i>i</i>
     * @param index the index where the task will be deleted
     */
    public void remove (int index) {
        taskList.remove(index);
    }
}
