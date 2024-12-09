package patternComandFinal;

public class CreateTaskCommand implements Command {
    private final Task task;
    private final TaskManager taskManager;

    public CreateTaskCommand(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        taskManager.addTask(task);
    }

    @Override
    public void undo() {
        taskManager.deleteTask(task);
    }

    @Override
    public void redo() {
        execute();
    }

    @Override
    public String getDescription() {
        return task.getDescription();
    }
}
