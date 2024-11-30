package patterns;

//Concrete Command
public class UpdateTaskCommand implements Command {
    private Task task;
    String prevDescription;

    public UpdateTaskCommand(Task task) {
        this.task = task;
    }

    @Override
    public void execute() {
        prevDescription = task.getDescription();
        task.updateTask(prevDescription);
    }

    @Override
    public void undo() {
        if (prevDescription != null && !prevDescription.equals(task.getDescription())) {
            task.setDescription(prevDescription);
        }
    }

//    @Override
//    public void redo(String description) {
//       task.setDescription(description);
//    }
}
