package General;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Storage {

    private File file;
    private PrintWriter pw;

    public Storage (String pathname) throws FileNotFoundException {
        file = new File(pathname);
    }

    public File getFile() {
        return file;
    }

    public void createNewFile() throws IOException {
        file.createNewFile();
    }

    public void openPW() throws FileNotFoundException {
        pw = new PrintWriter(file);
    }

    public void closePW() {
        pw.close();
    }

    public void print(String str) {
        pw.print(str);
    }

    public void println(String str) {
        pw.println(str);
    }
}
