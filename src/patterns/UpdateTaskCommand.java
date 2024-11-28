package patterns;

//Concrete Command
public class UpdateTaskCommand implements Command {
    private TaskManager taskManager;

    public UpdateTaskCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void execute() {
        taskManager.updateTask();
    }

//    @Override
//    public void undo() {
//
//    }
}
