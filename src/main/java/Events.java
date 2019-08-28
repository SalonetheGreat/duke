public class Events extends Task {

    protected String at;

    Events(String name, String at) {
        super(name);
        this.at = at;
    }

    @Override
    public String getClassID() {
        return "E";
    }

    @Override
    public String getTime() {
        return this.at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + "(at: " + at + ")";
    }
}
