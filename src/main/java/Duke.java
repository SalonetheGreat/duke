import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<Task> AL = new ArrayList<Task>();
        int len = 0;
        String[] Month = new String[]{"January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December"};

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
                    try {
                        FileWriter fw = new FileWriter("/Users/shalong/IdeaProjects/duke/data/duke.txt");
                        for (int i = 0; i < AL.size(); ++i) {
                            fw.write(AL.get(i).getClassID() + " | " + ((AL.get(i).isDone())?1:0) + " |" + AL.get(i).getName());
                            if (AL.get(i).getClassID().equals("T"))
                                fw.write("\n");
                            else
                                fw.write(" | " + AL.get(i).getTime() + "\n");
                        }
                        fw.close();
                    } catch (IOException e) {
                        System.out.println(e);
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
                    if (command.equals("todo")) { // add a todo
                        if (newTask[0].equals("")) {
                            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.");
                        }
                        AL.add(new Todo(newTask[0]));
                        System.out.println("Got it! I've added this task:\n" +
                                AL.get(AL.size()-1).toString() + "\n" +
                                "Now you have " + AL.size() + " tasks in the list.");
                    }
                    else if (command.equals("deadline")) { // add a deadline
                        try {
                            if (newTask.length == 4) {
                                try {
                                    // date & time
                                    int date = Integer.parseInt(newTask[1].substring(3));
                                    int month = Integer.parseInt(newTask[2]);
                                    int year = Integer.parseInt(newTask[3].split(" ")[0]);
                                    if (newTask[3].split(" ")[1].length() != 4)
                                        throw new NumberFormatException();
                                    int moment = Integer.parseInt(newTask[3].split(" ")[1]);
                                    StringBuilder time = new StringBuilder();
                                    if (date%10 == 1) time.append(date + "st of ");
                                    else if (date%10 == 2) time.append(date + "nd of ");
                                    else if (date%10 == 3) time.append(date + "rd of ");
                                    else time.append(date + "th of ");
                                    time.append(Month[month-1] + " " + year + ", ");
                                    if (moment/100 == 0) time.append("12am");
                                    else if (moment/100 < 12) time.append(moment/100 + "am");
                                    else time.append(moment/100 + "pm");
                                    AL.add(new Deadline(newTask[0], time.toString()));
                                } catch (NumberFormatException e) {
                                    StringBuilder time = new StringBuilder();
                                    for (int i = 1; i < newTask.length; ++i) {
                                        if (i != 1) time.append("/");
                                        time.append(newTask[i]);
                                    }
                                    AL.add(new Deadline(newTask[0], time.toString().substring(3)));
                                }
                            } else {
                                StringBuilder time = new StringBuilder();
                                for (int i = 1; i < newTask.length; ++i) {
                                    if (i != 1) time.append("/");
                                    time.append(newTask[i]);
                                }
                                AL.add(new Deadline(newTask[0], time.toString().substring(3)));
                            }
                            System.out.println("Got it! I've added this task:\n" +
                                    AL.get(AL.size()-1).toString() + "\n" +
                                    "Now you have " + AL.size() + " tasks in the list.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("☹ OOPS!!! The description of a deadline need to contain a \"/\".");
                        }
                    }
                    else if (command.equals("event")) { // add an event
                        try {
                            if (newTask.length == 4) {
                                try {
                                    // date & time
                                    int date = Integer.parseInt(newTask[1].substring(3));
                                    int month = Integer.parseInt(newTask[2]);
                                    int year = Integer.parseInt(newTask[3].split(" ")[0]);
                                    if (newTask[3].split(" ")[1].length() != 4)
                                        throw new NumberFormatException();
                                    int moment = Integer.parseInt(newTask[3].split(" ")[1]);
                                    StringBuilder time = new StringBuilder();
                                    if (date%10 == 1) time.append(date + "st of ");
                                    else if (date%10 == 2) time.append(date + "nd of ");
                                    else if (date%10 == 3) time.append(date + "rd of ");
                                    else time.append(date + "th of ");
                                    time.append(Month[month-1] + " " + year + ", ");
                                    if (moment/100 == 0) time.append("12am");
                                    else if (moment/100 < 12) time.append(moment/100 + "am");
                                    else time.append(moment/100 + "pm");
                                    AL.add(new Events(newTask[0], time.toString()));
                                } catch (NumberFormatException e) {
                                    StringBuilder time = new StringBuilder();
                                    for (int i = 1; i < newTask.length; ++i) {
                                        if (i != 1) time.append("/");
                                        time.append(newTask[i]);
                                    }
                                    AL.add(new Events(newTask[0], time.toString().substring(3)));
                                }
                            } else {
                                StringBuilder time = new StringBuilder();
                                for (int i = 1; i < newTask.length; ++i) {
                                    if (i != 1) time.append("/");
                                    time.append(newTask[i]);
                                }
                                AL.add(new Events(newTask[0], time.toString().substring(3)));
                            }
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
