package javaIO;

import java.util.InputMismatchException;
import java.util.Scanner;

public class inputError {
    public static void main(String[] args) {
        boolean isNum = false;
        while (!isNum) {
            try (Scanner sc = new Scanner(System.in)) {
                System.out.println(sc.nextInt() * 2);
                isNum = true;
            } catch (InputMismatchException e) {
                System.out.println("Ошибка ввода. Повторите ввод " + e.getMessage());
            }
        }
    }
}
