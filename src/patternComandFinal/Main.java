package patternComandFinal;


public class Main {
    public static void main(String[] args) {
        Task task1 = new Task(1, "Сделать домашнее задание");

        Invoker invoker = new Invoker();
        TaskManager taskManager = new TaskManager();

        CreateTaskCommand createTask = new CreateTaskCommand(taskManager, task1);
        invoker.executeCommand(createTask);
        invoker.executeCommand(createTask);
        invoker.executeCommand(createTask);
        invoker.executeCommand(createTask);
        invoker.undoCommand(createTask);
        invoker.undoCommand(createTask);
        invoker.undoCommand(createTask);

        DeleteTaskCommand deleteTask = new DeleteTaskCommand(taskManager, task1);
        invoker.executeCommand(deleteTask);
        invoker.undoCommand(deleteTask);

        UpdateTaskCommand updateTask = new UpdateTaskCommand(taskManager, task1, "Задание выполнено");
        invoker.executeCommand(updateTask);
//        invoker.undoCommand(updateTask);

        taskManager.printTasks();
        System.out.println(invoker);
    }
}
