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
            String command = sc.next();

            if (command.equals("bye"))
                break;

            if (command.equals("list")) { // list all item
                for (int i = 0; i < AL.size(); ++i) {
                    System.out.println((i+1) + "." + AL.get(i).toString());
                }
            } else if (command.equals("done")) { // set item to done
                int index = sc.nextInt() - 1;
                AL.get(index).setDone();
                System.out.println("Nice! I've marked this task as done:\n" +
                        AL.get(index).toString());
            } else { // add item
                String[] newTask = sc.nextLine().split("/");
                if (command.equals("todo")) AL.add(new Todo(newTask[0]));
                else if (command.equals("deadline")) AL.add(new Deadline(newTask[0], newTask[1]));
                else if (command.equals("event")) AL.add(new Events(newTask[0], newTask[1]));
                // print the boring statement
                System.out.println("Got it! I've added this task:\n" +
                        AL.get(AL.size()-1).toString() + "\n" +
                        "Now you have " + AL.size() + " tasks in the list.");
            }
            System.out.println("");
        }

        System.out.println("Bye. Hope to see you again!");
    }
}
