package javaIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class inputError {
    public static void main(String[] args) {
        boolean isNum = false;
        try (Scanner sc = new Scanner(System.in)) {
            while (!isNum) {
                try {
                    System.out.println(sc.nextInt() * 2);
                    isNum = true;
                } catch (InputMismatchException e) {
                    System.out.println("Ошибка ввода. Введите число.");
                    sc.next();
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка " + e.getMessage());
        }
    }
}
