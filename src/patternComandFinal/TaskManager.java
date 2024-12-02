package patternComandFinal;

public class TaskManager {
    private Task[] tasks = new Task[1];

    public void addTask(Task task) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                return;
            } else if (i == tasks.length - 1 && tasks[i] != null) {
                increaseTasksArray(tasks);
                tasks[tasks.length - 1] = task;
                return;
            }
        }
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
        for (Task value : tasks) {
            if (value != null && value.equals(task)) {
                value.setDescription(updateDescription);
            }
        }
    }

    public void printTasks() {
        System.out.println("Список текущих задач");
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                String res = String.format("Задача № %d \"%s\" с id: %d%n", i + 1, tasks[i].getDescription(), tasks[i].getId());
                System.out.println(res);
            }
        }
    }

    public void increaseTasksArray(Task[] tasks) {
        Task[] newTasks = new Task[tasks.length + 1];
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        this.tasks = newTasks;
    }
}
