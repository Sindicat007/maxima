package Polimorf;

public class Manager extends Employee {
    public Manager(String name, int salary) {
        super(name, salary);
    }
    @Override
    public int getSalary() {
        return salary;
    }

    public void work() {
        System.out.println("Менеджер " + getName() +  ", управляет командой");
    }
}
