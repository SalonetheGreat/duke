import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<Task> AL = new ArrayList<Task>();
        int len = 0;

        // hello
        System.out.println("Hello, I'm Duke\nWhat can I do for you?\n");

        while (true) {
            input = sc.next();

            if (input.equals("bye"))
                break;

            if (input.equals("list")) {
                for (int i = 0; i < AL.size(); ++i) {
                    System.out.print((i+1) + ".[");
                    if (AL.get(i).isDone())
                        System.out.print("√");
                    else
                        System.out.print("x");
                    System.out.println("] " + AL.get(i).getName());
                }
            } else if (input.equals("done")) {
                input = sc.next();
                int index = Integer.parseInt(input) - 1;
                AL.get(index).setDone();
                System.out.println("Nice! I've marked this task as done:\n" +
                        "[√] " + AL.get(index).getName());
            } else {
                AL.add(new Task(input));
                System.out.println("added: " + input);
            }
            System.out.println("");
        }

        System.out.println("Bye. Hope to see you again!");
    }
}
