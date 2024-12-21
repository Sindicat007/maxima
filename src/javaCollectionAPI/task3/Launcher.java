package javaCollectionAPI.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Launcher {
    private final Journal journal;
    private Scanner scan;
    private boolean isWork = true;
    private final String menu = """
            1. Добавить студента\s
            2. Добавить оценку студенту\s
            3. Показать студентов и их средние оценки\s
            4. Выйти\s
            """;

    public Launcher(Journal journal) {
        this.journal = journal;
    }

    public void launch() {
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
                case "2" -> addGradeInJournal();
                case "3" -> journal.printStudents();
                case "4" -> isWork = false;
                default -> System.out.println("Выбранное действие не предусмотрено, попробуйте снова.");
            }
        }
        scan.close();
    }

    private void addGradeInJournal() {
        int grade;
        System.out.println("Введите имя студента");
        String nameStudent = scan.nextLine();
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
