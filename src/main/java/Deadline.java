public class Deadline extends Task {

    protected String by;

    Deadline(String name, String by) {
        super(name);
        this.by = by.substring(3);
    }

    @Override
    public String getClassID() {
        return "D";
    }

    @Override
    public String getTime() {
        return this.by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + "(by: " + by + ")";
    }
}

