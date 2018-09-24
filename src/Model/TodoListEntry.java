package Model;

public class TodoListEntry {
    private static final int HIGH = 1;
    private static final int MEDIUM = 2;
    private static final int LOW = 3;

    public static final String HIGH_STRING = "High";
    public static final String MEDIUM_STRING = "Medium";
    public static final String LOW_STRING = "Low";

    private String activity;
    private int priority;
    private double time;


    // REQUIRES: priority to be one of low, medium, high
    // MODIFIES: this
    // EFFECTS: Constructs a TodoListEntry using activity, priority, and time information
    // called to constructor
    public TodoListEntry(String activity, String priority, double time) {
        this.activity = activity;
        this.time = time;
        this.priority = priorityStringToInt(priority);
    }

    private int priorityStringToInt(String priority) {
        if (priority.equalsIgnoreCase("high")) {
            return HIGH;
        }
        else if (priority.equalsIgnoreCase("medium")) {
            return MEDIUM;
        }
        else {
            return LOW;
        }
    }

    // EFFECTS: Returns contents of TodoListEntry in form of Activity,
    // priorityLevel(low, medium, high), time(in hrs)
    public String getTodoInfo() {
        return activity+ ", " +this.getPriorityLevel()+ ", " +time;
    }


    // EFFECTS: Returns the activity
    public String getActivity() {
        return activity;
    }

    // EFFECTS: Returns time needed for activity
    public double getTime() {
        return time;
    }

    // EFFECTS: Return integer representation of priority
    public int getPriority() {
        return priority;
    }

    // REQUIRES: priority level from LOW-HIGH
    // EFFECTS: Takes an integer representation of priority and returns its string equivalent
    public String getPriorityLevel() {
        switch (priority) {
            case HIGH:
                return HIGH_STRING;
            case MEDIUM:
                return MEDIUM_STRING;
            case LOW:
                return LOW_STRING;
        }
        return LOW_STRING;
    }

    @Override
    // EFFECTS: checks if object is a TodoListEntry and if it is equal to this
    public boolean equals(Object obj) {
        if (obj instanceof TodoListEntry) {
            TodoListEntry entry = (TodoListEntry) obj;
            return activity.equals(entry.getActivity())
                    && priority == entry.getPriority() && time == entry.getTime();
        }
        return false;
    }

}
