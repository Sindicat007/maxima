package Recursion;

import java.util.Scanner;

public class FibSum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Расчеты числа Фибоначчи по его порядковому номеру. \n" + "Введите порядковый номер числа: ");
        int num = scan.nextInt();
        System.out.println(fibRec(num));
    }

    public static int fibFor(int a) {
        int result = 0;
        int buf1 = 0;
        int buf2 = 1;
        for (int i = 1; i < a; i++) {
            result = buf1 + buf2;
            buf1 = buf2;
            buf2 = result;
        }
        return result;
    }

    public static long fibRec(int a) {
        if (a <= 1) return a;
        return fibRec(a - 1) + fibRec(a - 2);
    }
}
