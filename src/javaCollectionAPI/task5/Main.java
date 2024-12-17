package javaCollectionAPI.task5;

public class Main {
    public static void main(String[] args) {


        TaskManager task = new TaskManager();
        task.addTask("Go to job");
        task.addTask("Go home");
        task.addTask("Go gym");
        task.addTask("Go job");

        task.deleteTask(5);

        task.getTaskList();

        task.moveTask(2,"top");
        System.out.println();
        task.getTaskList();
    }
}
