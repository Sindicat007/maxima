package patterns;

public class TaskManager {

    public static void main(String[] args) {
        Task taskOne = new Task(1,"Сделать домашнее задание" );

        CreateTaskCommand createTask = new CreateTaskCommand(taskOne);
        DeleteTaskCommand deleteTask = new DeleteTaskCommand(taskOne);
        UpdateTaskCommand updateTask = new UpdateTaskCommand(taskOne);

        taskOne.setDescription("Новое задание");


        Invoker invoker = new Invoker();
        invoker.setCommand(createTask, deleteTask, updateTask);

        invoker.createTask();
//        updateTask.setDescription("Новое задание");
        invoker.updateTask("Новое задание");
        invoker.undoLastAction();
        invoker.deleteTask();

        System.out.println(invoker);
    }
}