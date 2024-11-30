package patterns;

public class DeleteTaskCommand implements Command {
    private Task task;

    public DeleteTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        task.deleteTask();
    }

    @Override
    public void undo() {
        task.createTask();
    }

//    @Override
//    public void redo(String id) {
//        NoCommand noCommand;
//    }
}
