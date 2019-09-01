import Command.*;
import General.DukeException;
import General.Message;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Parser {
    private static final String BYE = "bye";
    private static final String LIST = "list";
    private static final String DONE = "done";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";

    public static Command getCommand (String line) throws DukeException {
        Scanner input = new Scanner(line);
        try {
            String command = input.next();
            switch (command) {
                case BYE:
                    return getByeCommand(line);
                case LIST:
                    return getListCommand(line);
                case DONE:
                    return getDoneCommand(line);
                case TODO:
                case DEADLINE:
                case EVENT:
                    return getAddCommand(line);
                default:
                    throw new DukeException(Message.getOops() + "I'm sorry, but I don't know what that means :-(");
            }
        } catch (NoSuchElementException e) {
            throw new DukeException(Message.getOops() + "You cannot enter a empty line!");
        }
    }

    private static Command getByeCommand (String line) throws DukeException {
        return new ByeCommand(line);
    }
    private static Command getListCommand(String line) throws DukeException {
        return new ListCommand(line);
    }
    private static Command getAddCommand(String line) {
        return new AddCommand(line);
    }
    private static Command getDoneCommand(String line) throws DukeException {
        return new DoneCommand(line);
    }
}
