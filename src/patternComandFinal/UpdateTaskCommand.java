package patternComandFinal;

public class UpdateTaskCommand implements Command {
    private Task[] task;
    private String description;
    private String lastDescription;
    private int id;

    public UpdateTaskCommand(Task[] task, String description, int id) {
        this.task = task;
        this.description = description;
        this.id = id;
    }

    @Override
    public void execute() {
        lastDescription = task[id].getDescription();
        task[id].setDescription(description);
    }

    @Override
    public void undo() {
        task[id].setDescription(lastDescription);
    }
}
