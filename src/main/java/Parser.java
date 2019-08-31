import Command.*;

public class Parser {
    private static final String BYE = "bye";
    private static final String LIST = "list";

    public static Command getCommand (String line) {
        switch (line) {
            case BYE:
                return getByeCommand();
            case LIST:
                return getListCommand();
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
}
