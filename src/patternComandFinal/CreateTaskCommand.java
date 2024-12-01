package patternComandFinal;

public class CreateTaskCommand implements Command {
    private Task task;
    private TaskManager taskManager;

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
}
