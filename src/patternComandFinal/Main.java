package patternComandFinal;

public class Main {
    public static void main(String[] args) {
        Task task1 = new Task(1, "Сделать домашнее задание");

        Invoker invoker = new Invoker();
        TaskManager taskManager = new TaskManager();

        CreateTaskCommand createTask = new CreateTaskCommand(taskManager, task1);
        invoker.executeCommand(createTask);
        taskManager.printTasks();

        DeleteTaskCommand deleteTask = new DeleteTaskCommand(taskManager, task1);
        invoker.executeCommand(deleteTask);
        taskManager.printTasks();
        invoker.undoCommand(deleteTask);
        taskManager.printTasks();

        UpdateTaskCommand updateTask = new UpdateTaskCommand(taskManager, task1, "Задание выполнено");
        invoker.executeCommand(updateTask);
        taskManager.printTasks();
        invoker.undoCommand(updateTask);

        taskManager.printTasks();
    }
}
