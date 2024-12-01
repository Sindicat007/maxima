package patternComandFinal;

public class TaskManager {
    public static void main(String[] args) {
        Invoker invoker = new Invoker();
        Task[] tasks = {
                new Task(1, "Task 1"),
                new Task(2, "Task 2"),
                new Task(3, "Task 3"),
                new Task(4, "Task 4"),
                new Task(5, "Task 5"),
                new Task(6, "Task 6"),
                new Task(7, "Task 7"),
                new Task(8, "Task 8"),
                new Task(9, "Task 9"),
                new Task(10, "Task 10"),
        };

        printTasks(tasks);
        System.out.println("create 9");
        CreateTaskCommand createTask = new CreateTaskCommand(tasks, 8, "New task");
        invoker.setCommand(createTask);
        invoker.executeCommand();
        printTasks(tasks);

        System.out.println("Delete 4");
        DeleteTaskCommand deleteTask = new DeleteTaskCommand(tasks, 3);
        invoker.setCommand(deleteTask);
        invoker.executeCommand();
        printTasks(tasks);

        System.out.println("Update 5");
        UpdateTaskCommand updateTask = new UpdateTaskCommand(tasks, "Новое задание", 4);
        invoker.setCommand(updateTask);
        invoker.executeCommand();
        printTasks(tasks);


        System.out.println("Create 4");
        CreateTaskCommand createTask1 = new CreateTaskCommand(tasks, 3, "New task1");
        invoker.setCommand(createTask1);
        invoker.executeCommand();
        printTasks(tasks);

        System.out.println("Delete 3");
        DeleteTaskCommand deleteTask2 = new DeleteTaskCommand(tasks, 2);
        invoker.setCommand(deleteTask2);
        invoker.executeCommand();
        printTasks(tasks);

        System.out.println("Undo");
        invoker.undoCommand();
        printTasks(tasks);
    }

    public static void printTasks(Task[] tasks) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                System.out.println(tasks[i].getId() + " " + tasks[i].getDescription());
            }
        }
        System.out.println();
    }


}
