package Recursion;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        sumMethods();
    }

    public static void sumMethods() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введи любое положительное число, до которого нужно посчитать сумму чисел от 1: ");
        int num = scan.nextInt();
        System.out.println(sumFor(num));
//        System.out.println(sumRecursion(num));
        scan.close();
    }

    public static int sumFor(int a) {
        if (a <= 1) {
            return 1;
        }
        int result = 0;
        for (int i = 1; i <= a; i++) {
            result += i;
        }
        return result;
    }

    public static int sumRecursion(int a) {
        if (a <= 1) {
            return 1;
        }
        return a + sumRecursion(a - 1);
    }
}
