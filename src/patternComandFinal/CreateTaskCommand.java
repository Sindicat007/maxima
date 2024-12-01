package patternComandFinal;

public class CreateTaskCommand implements Command {
    private int id;
    private Task[] tasks;
    private String description;

    public CreateTaskCommand(Task[] tasks, int id, String description) {
        this.tasks = tasks;
        this.id = id;
        this.description = description;
    }

    @Override
    public void execute() {
        tasks[id] = new Task(id + 1, description);
//        id = tasks.getId();
//        tasks.createTask(id, description);
    }

    @Override
    public void undo() {
        tasks[id].deleteTask(id);
    }
}
