import Command.*;
import General.DukeException;
import General.Message;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Parse the string of command into different types of commands
 */
public class Parser {
    private static final String BYE = "bye";
    private static final String LIST = "list";
    private static final String DONE = "done";
    private static final String DELETE = "delete";
    private static final String TODO = "todo";
    private static final String DEADLINE = "deadline";
    private static final String EVENT = "event";
    private static final String FIND = "find";

    /**
     * Parse the string to a <code>Command</code> object
     * @param line The string to be parsed
     * @return One of the child command in class <code>Command</code>
     * @throws DukeException If the user enters an empty line or unrecognizable command
     */
    public static Command parse (String line) throws DukeException {
        Scanner input = new Scanner(line);
        try {
            String command = input.next();
            switch (command) {
                case BYE:
                    return getExitCommand(line);
                case LIST:
                    return getListCommand(line);
                case DONE:
                    return getDoneCommand(line);
                case DELETE:
                    return getDeleteCommand(line);
                case TODO:
                case DEADLINE:
                case EVENT:
                    return getAddCommand(line);
                case FIND:
                    return getFindCommand(line);
                case "fuck":
                    throw new DukeException("You cannot talk dirty! :)");
                default:
                    throw new DukeException(Message.getOops() + "I'm sorry, but I don't know what that means :-(");
            }
        } catch (NoSuchElementException e) {
            throw new DukeException(Message.getOops() + "You cannot enter a empty line!");
        }
    }

    /**
     * Get an Exit command using a string
     * @param line The string used for creating an Exit Command
     * @return An <code>ExitCommand</code> Object
     * @throws DukeException If fail to construct
     */
    private static Command getExitCommand (String line) throws DukeException {
        return new ExitCommand(line);
    }

    /**
     * Get an List Command using a string
     * @param line The string used for creating a List Command
     * @return An <code>ListCommand</code> Object
     * @throws DukeException If fail to construct
     */
    private static Command getListCommand(String line) throws DukeException {
        return new ListCommand(line);
    }

    /**
     * Get an Add Command
     * @param line The string used for creating an Add command
     * @return An <code>AddCommand</code> Object
     */
    private static Command getAddCommand(String line) {
        return new AddCommand(line);
    }

    /**
     * Get a Done Command
     * @param line The string used for creating a Done Command
     * @return A <code>DoneCommand</code> Object
     * @throws DukeException If fail to construct
     */
    private static Command getDoneCommand(String line) throws DukeException {
        return new DoneCommand(line);
    }

    /**
     * Get a Delete Command
     * @param line The string used for creating a delete command
     * @return A <code>DeleteCommand</code> object
     * @throws DukeException If fail to construct
     */
    private static Command getDeleteCommand(String line) throws DukeException {
        return new DeleteCommand(line);
    }

    /**
     * Get a Find command
     * @param line The string used for creating a find command
     * @return A <code>FindCommand</code> object
     * @throws DukeException If fail to construct
     */
    private static Command getFindCommand(String line) throws DukeException {
        return new FindCommand(line);
    }
}
