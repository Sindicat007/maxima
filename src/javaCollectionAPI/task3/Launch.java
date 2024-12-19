package javaCollectionAPI.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launch {
    Scanner scan;
    private boolean isWork = true;
    String menuListStr = """
            1. Добавить студента\s
            2. Добавить оценку студенту\s
            3. Показать студентов и их средние оценки\s
            4. Выйти\s
            """;

    public void navigationStart(Journal journal) {
        scan = new Scanner(System.in);
        String valNav;
        System.out.println("--------- Учебный журнал ---------");

        while (isWork) {
            System.out.println(menuListStr);
            System.out.println("Выберите действие");
            valNav = scan.nextLine();

            switch (valNav) {
                case "1" -> {
                    System.out.println("Введите имя студента");

                    journal.addStudent(scan.nextLine());
                }
                case "2" -> {
                    String nameStudent;
                    int valjournalNav;
                    System.out.println("Введите имя студента");
                    nameStudent = scan.nextLine();
                    System.out.printf("Введите оценку студента от %d до %d%n", Journal.MIN_GRADE, Journal.MAX_GRADE);
                    while (true) {
                        try {
                            valjournalNav = scan.nextInt();
                            break;
                        } catch (InputMismatchException e) {
                            System.out.printf("Введите число от %d до %d%n", Journal.MIN_GRADE, Journal.MAX_GRADE);
                            scan.next();
                        }
                    }
                    journal.addGrade(nameStudent, valjournalNav);
                    scan.nextLine();
                }
                case "3" -> journal.getStudents();
                case "4" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
        scan.close();
    }
}
