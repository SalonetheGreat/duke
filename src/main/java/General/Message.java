package General;

public class Message {
    private static final String hello = "Hello! I'm Duke\nWhat can I do for you?";
    private static final String bye = "Bye! Hope to see you again soon!";

    public static String getHello() {
        return hello;
    }
    public static String getBye() {
        return bye;
    }

    public static String getAdd(String s) {
        return "added " + s;
    }
}
