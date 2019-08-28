public class Todo extends Task {
    Todo(String name) {
        super(name);
    }

    @Override
    public String getClassID() {
        return "T";
    }

    @Override
    public String getTime() {
        return null;
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}
