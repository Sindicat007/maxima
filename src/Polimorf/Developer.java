package Polimorf;

public class Developer extends Employee {
    private String levelExperience;

    public Developer(String name, int salary, String levelExperience) {
        super(name, salary);
        this.levelExperience = levelExperience;
    }

    public String getLevelExperience() {
        return levelExperience;
    }

    public void setLevelExperience(String levelExperience) {
        this.levelExperience = levelExperience;
    }

    @Override
    public int getSalary() {
        return salary;
    }

    public void work() {
        System.out.println("Разработчик " + levelExperience + " - " + getName() + ", пишет код");
    }
}
