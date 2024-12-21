package javaCollectionAPI.task5;

public class Main {
    public static void main(String[] args) {

        TaskManager task = new TaskManager();
        Launcher launcher = new Launcher();

        task.addTask("Go job");
        task.addTask("Go gym");
        task.addTask("Go home");
        task.addTask("Go code");

        launcher.launch(task);

    }
}
