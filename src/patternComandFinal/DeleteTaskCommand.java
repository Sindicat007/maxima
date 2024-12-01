package patternComandFinal;

public class DeleteTaskCommand implements Command {
    private Task[] task;
    private int id;
    private int lastId;
    private String description;
    private Task noCommand;

    public DeleteTaskCommand(Task[] task, int id) {
        this.task = task;
        this.id = id;
    }

    @Override
    public void execute() {
        lastId = id;
        description = task[id].getDescription();
        task[id] = noCommand;
    }

    @Override
    public void undo() {
        task[lastId] = new Task(lastId + 1, description);
//        task[lastId].setDescription(description);
    }
}
