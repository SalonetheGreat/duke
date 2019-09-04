package General;

import java.util.Scanner;

public class Ui {

    public String readLine() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String readNext() {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }

    public void showWelcome() {
        System.out.println(Message.getHello());
    }

    public void showExit() {
        System.out.println(Message.getExit());
    }

    public void showException (Exception e) {
        System.out.println(e);
    }

    public void showMessage (String str) {
        System.out.print(str);
    }

    public void showMessageLn (String str) {
        System.out.println(str);
    }
}
