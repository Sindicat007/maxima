package Polimorf;

public class Employee {
    private String name;
    protected int salary;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return 0;
    }

    public void work() {
        System.out.println("Сотрудник выполняет работу");
    }

}
