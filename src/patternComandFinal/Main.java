package patternComandFinal;


public class Main {
    public static void main(String[] args) {
        Task doHomework = new Task(1, "Сделать домашнее задание");
        Task updateHomework = new Task(1, "Выполнено!!");
        Task flowerTask = new Task(2, "Полить цветы");

        Invoker invoker = new Invoker();
        TaskManager taskManager = new TaskManager();

        CreateTaskCommand createTaskCommand = new CreateTaskCommand(taskManager, doHomework);
        invoker.executeCommand(createTaskCommand);
        System.out.println("Домашнее задание создано");
        taskManager.printTasks();


        DeleteTaskCommand deleteTaskCommand = new DeleteTaskCommand(taskManager, doHomework);
        invoker.executeCommand(deleteTaskCommand);
        System.out.println("Домашнее задание удалено");
        taskManager.printTasks();


        invoker.undoCommand(deleteTaskCommand);
        System.out.println("Отменено удаление домашнего задания");
        taskManager.printTasks();


        CreateTaskCommand flowerCommand = new CreateTaskCommand(taskManager, flowerTask);
        invoker.executeCommand(flowerCommand);
        System.out.println("Задание с цветами создано");
        taskManager.printTasks();


        invoker.undoCommand(flowerCommand);
        System.out.println("Задание с цветами отменено");
        taskManager.printTasks();


        invoker.redo(flowerCommand);
        System.out.println("Задание с цветами повторено");
        taskManager.printTasks();


        UpdateTaskCommand updateHomeworkCommand = new UpdateTaskCommand(taskManager, updateHomework);
        invoker.executeCommand(updateHomeworkCommand);
        System.out.println("Домашнее задание обновлено");
        taskManager.printTasks();


        System.out.println(invoker);
    }
}