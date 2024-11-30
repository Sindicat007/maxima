package patterns;

public class Task {
    private int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void createTask() {
        System.out.printf(String.format("Задача с id %d %n'%s' создана %n%n", id, description));
    }

    public void updateTask(String description) {
//        System.out.printf("Описание задачи обновлено на %s%n%n", description);
        System.out.println("Описание задачи обновлен\n" + description);
    }

    public void deleteTask() {
        System.out.println("Задача удалена\n");
    }


//    public void redoTask(String description) {
//        System.out.println("Отредактировать задачу");
//    }
//
//    public void undoRedoTask() {
//        System.out.println("Отменить последнее редактирование");
//    }


}
