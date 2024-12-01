package patternComandFinal;

public class TaskManager {
    private Task[] tasks = new Task[10];

    public void addTask(Task task) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                return;
            }
        }
        System.out.println("Диспетчер задач заполнен");
    }

    public void deleteTask(Task task) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i].getId() == task.getId()) {
                tasks[i] = null;
                return;
            }
        }
        System.out.println("Такой задачи нет");
    }

    public void updateTask(Task task, String updateDescription) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null && tasks[i].equals(task)) {
                tasks[i].setDescription(updateDescription);
            }
        }
    }

    public void printTasks() {
        System.out.println("Список текущих задач");
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                String res = String.format("Задача \"%s\" с id: %d%n", tasks[i].getDescription(), tasks[i].getId());
                System.out.println(res);
            }
        }
    }
}
