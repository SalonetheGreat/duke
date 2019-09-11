package General;

/**
 * The class Message stores commonly used strings in Duke
 */
public final class Message {
    private static final String hello = "Hello! I'm Duke\nWhat can I do for you?";
    private static final String exit = "Bye! Hope to see you again soon!";
    private static final String list = "Here are the tasks in your list:";
    private static final String done = "Nice! I've marked this task as done:\n";
    private static final String add = "Got it. I've added this task:\n";
    private static final String oops = "☹ OOPS!!! ";
    private static final String delete1 = "Noted. I've removed this task: \n";
    private static final String delete2Front = "Now you have ";
    private static final String delete2Back = " tasks in the list.";
    private static final String find = "Here are the matching tasks in your list: ";

    /**
     * Get Hello message.
     * @return String of Hello message
     */
    public static String getHello() {
        return hello;
    }

    /**
     * Get Exit message.
     * @return String of Exit message
     */
    public static String getExit() {
        return exit;
    }

    /**
     * Get Add message given the task to be added.
     * @param s The string of the task to be added
     * @return A string of Add message
     */
    public static String getAdd(String s) {
        return add + s;
    }

    /**
     * Get List message.
     * @return A string of List message
     */
    public static String getList() {
        return list;
    }

    /**
     * Get Done message.
     * @return A string of Done message
     */
    public static String getDone() {
        return done;
    }

    /**
     * Get Oops message, which is used in DukeExceptions.
     * @return A string of Oops message
     */
    public static String getOops() {
        return oops;
    }

    /**
     * Get Delete message after deleting a Task.
     * @return A string of Delete1 message
     */
    public static String getDelete1() {
        return delete1;
    }

    /**
     * Get Delete message 2.
     * @param index # of elements left in the TaskList
     * @return A string of Delete2 message
     */
    public static String getDelete2(int index) {
        return delete2Front + (index+1) + delete2Back;
    }

    /**
     * Get Find message.
     * @return A string of Find message
     */
    public static String getFind() {
        return find;
    }
}
