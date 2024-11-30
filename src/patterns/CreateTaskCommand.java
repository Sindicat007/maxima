package patterns;

public class CreateTaskCommand implements Command {
    private Task task;
    private Command noCommand;

    public CreateTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        task.createTask();
    }

    @Override
    public void undo() {
        task.deleteTask();
//        noCommand.execute();
//        task.deleteTask(task.getId().toString());
    }

//    @Override
//    public void redo(String description) {
//        task.redoTask(description);
//    }
}
