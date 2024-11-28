package patterns;

//Concrete Command
public class DeleteTaskCommand implements Command {
    private TaskManager taskManager;

    public DeleteTaskCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void execute() {
        taskManager.deleteTask();
    }

//    @Override
//    public void undo() {
//
//    }
}
