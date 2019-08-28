public class Events extends Task {

    protected String at;

    Events(String name, String at) {
        super(name);
        this.at = at.substring(3);
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + ")";
    }
}
