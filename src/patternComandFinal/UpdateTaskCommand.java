package patternComandFinal;

public class UpdateTaskCommand implements Command {
    private final TaskManager taskManager;
    private final Task task;

    public UpdateTaskCommand(TaskManager taskManager, Task task) {
        this.taskManager = taskManager;
        this.task = task;
    }

    @Override
    public void execute() {
        taskManager.updateTask(task);
    }

    @Override
    public void undo() {
        taskManager.revertUpdate(task);
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
