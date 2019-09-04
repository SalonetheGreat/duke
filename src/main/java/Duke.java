import Command.Command;
import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.Task;
import Tasks.TaskList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) throws IOException {

        Ui ui = new Ui();
        ui.showWelcome();

        Storage file = new Storage("./data/duke.txt");
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
