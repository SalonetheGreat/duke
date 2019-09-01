import Command.Command;
import General.DukeException;
import General.Message;
import Tasks.Task;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        System.out.println(Message.getHello());
        Scanner input = new Scanner(System.in);

        ArrayList<Task> taskList = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line == "\n") System.exit(3);
            try {
                Command command = Parser.getCommand(line);
                command.execute(taskList);
            } catch (DukeException e) {
                System.out.println(e);
            }
        }
    }
}
