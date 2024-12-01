package patternComandFinal;

public class UpdateTaskCommand implements Command {
    private TaskManager taskManager;
    private Task task;
    private String updateDescription, lastDesc;

    public UpdateTaskCommand(TaskManager taskManager, Task task, String updateDescription) {
        this.taskManager = taskManager;
        this.task = task;
        this.updateDescription = updateDescription;
    }

    @Override
    public void execute() {
        lastDesc = task.getDescription();
        taskManager.updateTask(task, updateDescription);
    }

    @Override
    public void undo() {
        taskManager.updateTask(task, lastDesc);
    }
}
