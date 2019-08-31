import Command.Command;
import General.Message;

import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        System.out.println(Message.getHello());
        Scanner input = new Scanner(System.in);

        ArrayList<String> taskList = new ArrayList<>();

        while (input.hasNextLine()) {
            String line = input.nextLine();

            Command command = Parser.getCommand(line);
            command.execute(taskList);
        }
    }
}
