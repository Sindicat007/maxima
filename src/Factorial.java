import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        factorialMethods();
    }

    public static void factorialMethods() {
        System.out.println("Введите либое положительное число, факториал, которого нужно посчитать: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        if (num <= 1) {
            System.out.println("Число должно быть больше 1");
        } else {
            System.out.println("Каким способом хотите посчитать?\n" + "1 - Обычным методом\n" + "2 - Рекурсивным методом");
            int way = scan.nextInt();
            switch (way) {
                case 1:
                    System.out.println(factorialFor(num));
                    break;
                case 2:
                    System.out.println(factorialRec(num));
                    break;
                default:
                    System.out.println("Такого варианта нет, выберите из предложенных: 1 или 2");
            }
        }
        scan.close();
    }

    public static long factorialFor(int a) {
        if (a < 1) return 1;
        long result = 1;
        for (int i = 1; i <= a; i++) {
            result *= i;
        }
        return result;
    }

    public static long factorialRec(int a) {
        if (a < 1) return 1;
        return a * factorialRec(a - 1);
    }
}
