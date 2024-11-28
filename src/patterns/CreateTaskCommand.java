package patterns;

//Concrete Command
public class CreateTaskCommand implements Command {
    private TaskManager taskManager;

    public CreateTaskCommand(TaskManager taskManager) {
        this.taskManager = taskManager;
    }

    public void execute() {
        taskManager.createTask();
    }


    public void undo() {
        taskManager.deleteTask();
        System.out.println("Отменить задание");
    }
}
