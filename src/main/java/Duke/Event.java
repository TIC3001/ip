package Duke;

public class Event extends Task{
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    @Override
    public String toString() {
        return "[E] " + this.getStatusIcon() + " " + this.description + " (at: " + at + ")";
    }
}
