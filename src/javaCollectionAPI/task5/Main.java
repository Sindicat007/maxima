package javaCollectionAPI.task5;

public class Main {
    public static void main(String[] args) {


        TaskManager task = new TaskManager();
        Launch launch = new Launch();


        task.addTask("Go job");
        task.addTask("Go gym");
        task.addTask("Go home");
        task.addTask("Go code");

        launch.taskManagerStart(task);

    }
}
