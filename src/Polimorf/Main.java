package Polimorf;

import java.lang.reflect.Array;

public class Main {
    public static void main(String[] args) {
        Employee manager = new Manager("Алексей", 85000);
        Employee develop = new Developer("Данил", 350000, "Middle");
        Employee[] employHuman = {manager, develop, new Developer("Виктор", 125000, "Junior")};
        workAndSalary(employHuman);
//
    }

    public static void workAndSalary(Employee[] employees) {
        for (Employee item: employees){
            item.work();
            System.out.println("Зарплата: " + item.getSalary());
            System.out.println();
        }
    }
}
