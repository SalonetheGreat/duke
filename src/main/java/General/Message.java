package General;

public class Message {
    private static final String hello = "Hello! I'm Duke\nWhat can I do for you?";
    private static final String bye = "Bye! Hope to see you again soon!";
    private static final String list = "Here are the tasks in your list:";
    private static final String done = "Nice! I've marked this task as done:\n";
    private static final String add = "Got it. I've added this task:\n";
    private static final String oops = "☹ OOPS!!! ";

    public static String getHello() {
        return hello;
    }

    public static String getBye() {
        return bye;
    }

    public static String getAdd(String s) {
        return "added " + s;
    }

    public static String getList() {
        return list;
    }

    public static String getDone() {
        return done;
    }

    public static String getAdd() {
        return add;
    }

    public static String getOops() {
        return oops;
    }
}
