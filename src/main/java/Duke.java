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
            try {
                String command = sc.next();
                if (command.equals("")) throw new DukeException("☹ OOPS!!! You cannot enter a blank request.");

                if (command.equals("bye")) {
                    break;
                }

                if (command.equals("list")) { // list all item
                    for (int i = 0; i < AL.size(); ++i) {
                        System.out.println((i+1) + "." + AL.get(i).toString());
                    }
                } else if (command.equals("done")) { // set item to done
                    try {
                        int index = sc.nextInt() - 1;
                        AL.get(index).setDone();
                        System.out.println("Nice! I've marked this task as done:\n" +
                                AL.get(index).toString());
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("☹ OOPS!!! The index of a done should be in range.");
                    }
                } else { // add item
                    String[] newTask = sc.nextLine().split("/");
                    if (command.equals("todo")) { // add a todo task
                        if (newTask[0].equals("")) {
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        AL.add(new Todo(newTask[0]));
                        System.out.println("Got it! I've added this task:\n" +
                                AL.get(AL.size()-1).toString() + "\n" +
                                "Now you have " + AL.size() + " tasks in the list.");
                    }
                    else if (command.equals("deadline")) {
                        try {
                            AL.add(new Deadline(newTask[0], newTask[1]));
                            System.out.println("Got it! I've added this task:\n" +
                                    AL.get(AL.size()-1).toString() + "\n" +
                                    "Now you have " + AL.size() + " tasks in the list.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("☹ OOPS!!! The description of a deadline need to contain a \"/\".");
                        }
                    }
                    else if (command.equals("event")) {
                        try {
                            AL.add(new Events(newTask[0], newTask[1]));
                            System.out.println("Got it! I've added this task:\n" +
                                    AL.get(AL.size()-1).toString() + "\n" +
                                    "Now you have " + AL.size() + " tasks in the list.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("☹ OOPS!!! The description of an event need to contain a \"/\".");
                        }
                    }
                    else throw new DukeException("☹ OOPS!!! I'm sorry, but I don't know what that means...");
                }
            } catch (DukeException e) {
                System.out.println(e.toString());
            }
            System.out.println("");
        }

        System.out.println("Bye. Hope to see you again!");
    }
}
