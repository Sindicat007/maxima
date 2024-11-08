import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите первое число: ");
        int firstVal = scanner.nextInt();

        System.out.println("Введите второе число: ");
        int secondVal = scanner.nextInt();

        System.out.println("Введите тип операции (+, -, *, /): ");
        char operation = scanner.next().charAt(0);

        calcValue(firstVal, secondVal, operation);

        scanner.close();
    }
    public static void calcValue(int a, int b, char c) {
        int result = 0;
        switch (c) {
            case ('+'):
                result = a + b;
                System.out.println(result);
                break;
            case ('-'):
                result = a - b;
                System.out.println(result);
                break;
            case ('*'):
                result = a * b;
                System.out.println(result);
                break;
            case ('/'):
                if (b != 0){
                    double resultDiv = (double)a / (double)b;
                    System.out.println(resultDiv);
                }
                else {
                    System.out.println("На ноль делить нельзя");
                }
                break;
        }
    }
}
