package patternComandFinal;

public class TaskManager {
    private Task[] tasks = new Task[1];
    private Task[] historyUpdate = new Task[10];

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
        //TODO: добавить обновление в историю
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
                value.setDescription(newTask.getDescription());
            }
        }
        //TODO: добавить обновление в историю
    }

    public void revertUpdate(Task task) {
        String oldDescription = "";
        for (int i = historyUpdate.length - 1; i >= 0; i--) {
            if(historyUpdate[i] != null && historyUpdate[i].equals(task)) {
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

    public void increaseTasksArray(Task[] tasks) {
        Task[] newTasks = new Task[tasks.length * 2];
        System.arraycopy(tasks, 0, newTasks, 0, tasks.length);
        this.tasks = newTasks;
    }
}