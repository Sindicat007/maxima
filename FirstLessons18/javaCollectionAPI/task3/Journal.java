package javaCollectionAPI.task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Journal {

    private final Map<String, ArrayList<Integer>> nameToListGrade;

    public Journal() {
        this.nameToListGrade = new HashMap<>();
    }

    public void addStudent(String name) {
        if (name.isEmpty()) {
            System.out.println("Имя студента не может быть пустым");
            return;
        } else if (nameToListGrade.containsKey(name)) {
            System.out.printf("Студент с именем %s уже есть в списке %n", name);
            return;
        }
        nameToListGrade.put(name, new ArrayList<>());
        System.out.printf("Студент с именем %s добавлен %n", name);
    }

    public void addGrade(String name, int grade) {
        if (name.isEmpty() || !nameToListGrade.containsKey(name)) {
            System.out.println("Такого студента нет в журнале");
            return;
        } else if (grade < Constants.MIN_GRADE || grade > Constants.MAX_GRADE) {
            System.out.printf("Оценка должна быть в диапазоне от %d до %d %n", Constants.MIN_GRADE, Constants.MAX_GRADE);
            return;
        }
        nameToListGrade.get(name).add(grade);
    }

    public void printStudents() {
        for (Map.Entry<String, ArrayList<Integer>> value : nameToListGrade.entrySet()) {
            System.out.printf("Студент с именем %s имеет средний бал %.2f %n%n", value.getKey(), getAverageGrade(value.getValue()));
        }
    }

    public static double getAverageGrade(List<Integer> grades) {
        return grades.stream()
                .mapToDouble(val -> val)
                .average()
                .orElse(0.0);
    }
}
