package General;

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

    public static String getHello() {
        return hello;
    }

    public static String getExit() {
        return exit;
    }

    public static String getAdd(String s) {
        return add + s;
    }

    public static String getList() {
        return list;
    }

    public static String getDone() {
        return done;
    }

    public static String getOops() {
        return oops;
    }

    public static String getDelete1() {
        return delete1;
    }

    public static String getDelete2(int index) {
        return delete2Front + (index+1) + delete2Back;
    }

    public static String getFind() {
        return find;
    }
}
