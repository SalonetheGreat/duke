import General.Message;

import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println(Message.getHello());
        Scanner input = new Scanner(System.in);

        while (input.hasNextLine()) {
            String line = input.nextLine();
            System.out.println(line);
            if (line.equals("bye")) {
                System.out.println(Message.getBye());
                break;
            }
        }
    }
}
