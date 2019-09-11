package General;

import java.util.Scanner;

public class Ui {

    /**
     * Read a line from input
     * @return a string of the line of input
     */
    public String readLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /**
     * Show welcome message
     */
    public void showWelcome() {
        System.out.println(Message.getHello());
    }

    /**
     * Show exit message
     */
    public void showExit() {
        System.out.println(Message.getExit());
    }

    /**
     * Show Exception
     * @param e The exception to be shown
     */
    public void showException (Exception e) {
        System.out.println(e);
    }

    /**
     * Show message with a new line
     * @param str The message to be printed out
     */
    public void showMessageLn (String str) {
        System.out.println(str);
    }
}
