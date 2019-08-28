import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input;
        ArrayList<String> AL = new ArrayList<String>();
        int len = 0;

        // hello
        System.out.println("Hello, I'm Duke\nWhat can I do for you?\n");

        do {
            input = sc.next();
            if (input.equals("list")) {
                for (int i = 0; i < AL.size(); ++i)
                    System.out.println(AL.get(i));
            } else if (!input.equals("bye")) {
                AL.add(input);
                System.out.println("added: " + input);
            }
        } while (!input.equals("bye"));

        System.out.println("Bye. Hope to see you again!");
    }
}
