package patternComandFinal;

public class DeleteTaskCommand implements Command {
    private Task task;
    private TaskManager taskManager;

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
}
