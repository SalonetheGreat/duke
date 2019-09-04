package General;

import java.io.File;
import java.io.IOException;

public class Storage {

    private File file;

    public Storage (String pathname) {
        file = new File(pathname);
    }

    public File getFile() {
        return file;
    }

    public void createNewFile() throws IOException {
        file.createNewFile();
    }
}
