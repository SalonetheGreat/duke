package Command;

import General.Message;

import java.util.ArrayList;

public class AddCommand extends Command {
    String tbAdd;
    public AddCommand (String tbAdd) {
        this.tbAdd = tbAdd;
    }

    @Override
    public void execute(ArrayList<String> taskList) {
        taskList.add(tbAdd);
        System.out.println(Message.getAdd(tbAdd));
    }
}
