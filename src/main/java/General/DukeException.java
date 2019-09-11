package General;

public class DukeException extends Exception {
    private String description;

    /**
     * The only constructor for DukeException.
     * @param description The string to be assigned to description of the <code>DukeException</code> object
     */
    public DukeException(String description) {
        this.description = description;
    }

    /**
     * Description of the DukeException
     * @return A string of description
     */
    @Override
    public String toString() {
        return description;
    }
}
