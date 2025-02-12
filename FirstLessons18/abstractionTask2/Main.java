package abstractionTask2;

public class Main {
    public static void main(String[] args) {
        Manager man1 = new Manager("Alex", 41000, 25000);
        Developer dev = new Developer("Kris", 41000, 4);
        Employee man2 = new Manager("Victor", 41000, 12000);

        Employee[] employees = {man1, dev, man2};

        getPay(employees);
    }

    public static void getPay(Employee[] employees) {
        for (Employee employee : employees) {
            System.out.println(String.format("%s получает зарплату в размере %.1f", employee.getName(), employee.calculatePayment()));
        }
    }
}
