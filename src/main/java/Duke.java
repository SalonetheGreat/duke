import Command.Command;
import General.DukeException;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

import java.io.IOException;

/**
 * A class including main method
 */
public class Duke {
    /**
     * Main method
     * @param args The arguments to be passed in the main method
     * @throws IOException If fail to create the file
     */
    public static void main(String[] args) throws IOException {

        Ui ui = new Ui();
        ui.showWelcome();

        Storage file = new Storage("./data/tasks.txt");
        file.createNewFile();

        TaskList taskList = new TaskList();

        boolean isExit = false;
        while (!isExit) {
            try {
                String line = ui.readLine();
                Command command = Parser.parse(line);
                command.execute(taskList, ui,file);
                isExit = command.isExit();
            } catch (DukeException e) {
                ui.showException(e);
            }
        }
    }
}
