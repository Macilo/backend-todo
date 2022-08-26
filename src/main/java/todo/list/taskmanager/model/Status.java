package todo.list.taskmanager.model;

public enum Status {
    NOT_STARTED("Not Started"),
    IN_PROGRESS("In Progress"),
    IN_REVIEW("In Review"),
    COMPLETED("Completed"),
    CANCELLED("Caancelled");

    private String description;

    Status() {
    }

    Status(String decription) {
        this.description = decription;
    }

    public String getDescription() {
        return this.description;
    }
}
