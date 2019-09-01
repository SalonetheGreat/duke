import Command.Command;
import General.DukeException;
import General.Message;
import Tasks.Task;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws IOException {

        System.out.println(Message.getHello());
        Scanner input = new Scanner(System.in);

        File file = new File("./data/duke.txt");
        file.createNewFile();

        ArrayList<Task> taskList = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();
            if (line == "\n") System.exit(3);
            try {
                Command command = Parser.getCommand(line);
                command.execute(taskList, file);
            } catch (DukeException e) {
                System.out.println(e);
            }
        }
    }
}
