package patterns;

public class TaskManager {
//    private TaskManager[] tasks;
//    private static int count = 0;
//    public TaskManager(Command command) {
//        if (command instanceof CreateTaskCommand) {
//            tasks[count] = new TaskManager(command);
//        }
//    }

    public void createTask() {
        System.out.println("createTask");
    }
    public void deleteTask() {
        System.out.println("deleteTask");
    }
    public void updateTask() {
        System.out.println("updateTask");
    }
}
