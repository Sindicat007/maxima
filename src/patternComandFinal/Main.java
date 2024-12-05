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

        CreateTaskCommand flowerCommand = new CreateTaskCommand(taskManager, flowerTask);
        invoker.executeCommand(flowerCommand);

        invoker.undoCommand(flowerCommand);

        invoker.redo(flowerCommand);

        UpdateTaskCommand updateHomeworkCommand = new UpdateTaskCommand(taskManager, updateHomework);

        invoker.executeCommand(updateHomeworkCommand);

        /**
         * Создать
         * Обновить
         * ОТкатить обновление
         * Сново обновить
         */

        taskManager.printTasks();
        System.out.println(invoker);
    }
}
