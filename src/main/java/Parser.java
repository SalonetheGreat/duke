import Command.*;

import java.util.Scanner;

public class Parser {
    private static final String BYE = "bye";
    private static final String LIST = "list";
    private static final String DONE = "done";

    public static Command getCommand (String line) {
        Scanner input = new Scanner(line);
        String command = input.next();
        switch (command) {
            case BYE:
                return getByeCommand();
            case LIST:
                return getListCommand();
            case DONE:
                return getDoneCommand(line);
            default:
                return getAddCommand(line);
        }
    }

    private static Command getByeCommand () {
        return new ByeCommand();
    }
    private static Command getListCommand() {
        return new ListCommand();
    }
    private static Command getAddCommand(String line) {
        return new AddCommand(line);
    }
    private static Command getDoneCommand(String line) {
        return new DoneCommand(line);
    }
}
