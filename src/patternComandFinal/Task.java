package patternComandFinal;

public class Task {
    private int id;
    private String description;

    public Task(int id, String description) {
        this.id = id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void createTask(int id, String description) {
        System.out.printf("Задача id %d создана, описание: %s%n%n", id, description);
    }

    public void deleteTask(int id) {
        System.out.printf("Задача id %d удалена %n%n", id);
    }

    public void updateTask(int id, String description) {
        System.out.printf("Задача id %d обновлена, описание: %s%n%n", id, description);
    }
}
