package javaCollectionAPI.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    private Scanner scan;
    private boolean isWork = true;
    private String menu = """
            1. Добавить студента\s
            2. Добавить оценку студенту\s
            3. Показать студентов и их средние оценки\s
            4. Выйти\s
            """;

    public void launch(Journal journal) {
        scan = new Scanner(System.in);
        String choiceMenu;
        System.out.println("--------- Учебный журнал ---------");

        while (isWork) {
            System.out.println(menu);
            System.out.println("Выберите действие");
            choiceMenu = scan.nextLine();

            switch (choiceMenu) {
                case "1" -> {
                    System.out.println("Введите имя студента");
                    journal.addStudent(scan.nextLine());
                }
                case "2" -> addGradeInJournal(journal);
                case "3" -> journal.printStudents();
                case "4" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
        scan.close();
    }

    private void addGradeInJournal(Journal journal) {
        String nameStudent;
        int grade;
        System.out.println("Введите имя студента");
        nameStudent = scan.nextLine();
        System.out.printf("Введите оценку студента от %d до %d%n", Constants.MIN_GRADE, Constants.MAX_GRADE);
        while (true) {
            try {
                grade = scan.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.printf("Введите число от %d до %d%n", Constants.MIN_GRADE, Constants.MAX_GRADE);
                scan.next();
            }
        }
        journal.addGrade(nameStudent, grade);
        scan.nextLine();
    }
}
