package patternComandFinal;

public class DeleteTaskCommand implements Command {
    private final Task task;
    private final TaskManager taskManager;

    public DeleteTaskCommand(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        taskManager.deleteTask(task);
    }

    @Override
    public void undo() {
        taskManager.addTask(task);
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
