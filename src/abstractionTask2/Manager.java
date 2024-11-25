package abstractionTask2;

public class Manager extends Employee {
    private double bonus;

    public Manager(String name, double baseSalary, double bonus) {
        this.name = name;
        this.baseSalary = baseSalary;
        this.bonus = bonus;

    }

    @Override
    public double calculatePayment() {
        return baseSalary + bonus;
    }
}
