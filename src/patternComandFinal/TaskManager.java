package patternComandFinal;

import org.jetbrains.annotations.NotNull;

public class TaskManager {
    private Task[] tasks = new Task[1];
    private Task[] historyUpdate = new Task[1];

    public void addTask(Task task) {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                tasks[i] = task;
                return;
            } else if (i == tasks.length - 1 && tasks[i] != null) {
                tasks = increaseTasksArray(tasks);
                tasks[tasks.length - 1] = task;
                return;
            }
        }
        if (task.getId() >= historyUpdate.length) {
            historyUpdate = increaseTasksArray(historyUpdate);
        }
        historyUpdate[task.getId()] = task;
    }

    public void deleteTask(Task task) {
        for (int i = tasks.length - 1; i >= 0; i--) {
            if (tasks[i] != null && tasks[i].getId() == task.getId()) {
                tasks[i] = null;
                return;
            }
        }
        System.out.println("Такой задачи нет");
    }

    public void updateTask(Task newTask) {
        for (Task value : tasks) {
            if (value != null && value.equals(newTask)) {
                if (value.getId() >= historyUpdate.length) {
                    historyUpdate = increaseTasksArray(historyUpdate);
                }
                historyUpdate[value.getId()] = value;
                value.setDescription(newTask.getDescription());
            }
        }
    }

    public void revertUpdate(Task task) {
        String oldDescription = "";
        for (int i = historyUpdate.length - 1; i >= 0; i--) {
            if (historyUpdate[i] != null && historyUpdate[i].equals(task)) {
                oldDescription = historyUpdate[i].getDescription();
            }
        }
        for (Task value : tasks) {
            if (value != null && value.equals(task)) {
                value.setDescription(oldDescription);
            }
        }
    }

    public void printTasks() {
        System.out.println("Список текущих задач");
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] != null) {
                String res = String.format("Задача № %d \"%s\" с id: %d%n", i + 1, tasks[i].getDescription(), tasks[i].getId());
                System.out.print(res);
            }
        }
        System.out.println();
    }

    public Task[] increaseTasksArray(Task @NotNull [] tasks) {
        Task[] newTasks = new Task[tasks.length * 2];
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        return newTasks;
    }
}