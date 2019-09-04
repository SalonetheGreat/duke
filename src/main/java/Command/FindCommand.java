package Command;

import General.DukeException;
import General.Message;
import General.Storage;
import General.Ui;
import Tasks.TaskList;

import java.io.FileNotFoundException;

public class FindCommand extends Command {

    private String toFind;

    public FindCommand(String line) throws DukeException {
        try {
            toFind = line.substring(5);
        } catch (StringIndexOutOfBoundsException e) {
            throw new DukeException(Message.getOops() + "The description of a find cannot be empty.");
        }
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException, FileNotFoundException {
        ui.showMessageLn(Message.getFind());
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getName().contains(toFind))
                ui.showMessageLn((i+1) + ". " + taskList.get(i));
        }
    }
}
