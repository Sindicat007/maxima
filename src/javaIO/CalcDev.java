package javaIO;

public class CalcDev {
    public static void main(String[] args) {
        devide(5,0);

    }

    public static double devide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("Делить на ноль нельзя " + e.getMessage());
            return 0;
        }
        finally {
            System.out.println("Операция деление завершилась.");
        }
    }
}
