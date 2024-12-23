package StreamApi.task4;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Name1", 90));
        students.add(new Student("Name2", 80));
        students.add(new Student("Name3", 92));
        students.add(new Student("Name4", 60));
        students.add(new Student("Name5", 50));
        students.add(new Student("Name6", 40));
        students.add(new Student("Name7", 30));

        //Сгруппируйте студентов по оценкам
        Map<String, List<Student>> map = students.stream()
                .collect(Collectors.groupingBy(student -> {
                            if (student.getGrade() >= 90) return "90+";
                            else if (student.getGrade() >= 80) return "80-89";
                            else if (student.getGrade() >= 70) return "70-79";
                            else if (student.getGrade() >= 60) return "60-69";
                            else if (student.getGrade() >= 50) return "50-59";
                            else if (student.getGrade() >= 0) return "0-49";
                            else return "0";
                        }
                ));

        for (Map.Entry<String, List<Student>> entry : map.entrySet()) {
            System.out.println(entry.getKey());
            entry.getValue().forEach(person -> System.out.println(person.getName() + " " + person.getGrade() + " "));
        }
        System.out.println();

        //Определите, кто из студентов получил наивысшую оценку
        String maxGradeStudent = students.stream()
                .max(Comparator.comparingInt(Student::getGrade))
                .map(person -> person.getName() + " " + person.getGrade())
                .orElse(null);

        System.out.printf("Наивысший балл: %s %n", maxGradeStudent);
        System.out.println();

        //Посчитайте, сколько студентов получили оценку ниже 50
        long lessThan50 = students.stream()
                .filter(student -> student.getGrade() < 50)
                .count();

        System.out.printf("%d студентов получили оценки ниже 50%n", lessThan50);

    }
}
