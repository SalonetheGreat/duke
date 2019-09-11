package General;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class Storage {

    private File file;
    private PrintWriter pw;

    /**
     * The only constructor for class <code>Storage</code>.
     * @param pathname The pathway to the file
     * @throws FileNotFoundException If the pathway did't point to any file
     */
    public Storage (String pathname) throws FileNotFoundException {
        file = new File(pathname);
    }

    /**
     * Get File of the Storage.
     * @return The <code>File</code> object of the Storage
     */
    public File getFile() {
        return file;
    }

    /**
     * Create a new file.
     * @throws IOException If fail to create new file
     */
    public void createNewFile() throws IOException {
        file.createNewFile();
    }

    /**
     * Open a Printwriter at file.
     * @throws FileNotFoundException If file doesn't exist
     */
    public void openPW() throws FileNotFoundException {
        pw = new PrintWriter(file);
    }

    /**
     * Close Printwriter.
     */
    public void closePW() {
        pw.close();
    }

    /**
     * Print to Printwriter
     * @param str The string to be printed
     */
    public void print(String str) {
        pw.print(str);
    }

    /**
     * Print to Printwriter with a new line.
     * @param str The string to be printed
     */
    public void println(String str) {
        pw.println(str);
    }
}
