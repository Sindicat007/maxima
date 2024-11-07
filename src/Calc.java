import java.util.Scanner;

public class Calc {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int firstVal = scanner.nextInt();
        System.out.println("Введите второе число: ");
        int secondVal = scanner.nextInt();
        System.out.println("Введите тип операции: ");
        String operation = scanner.nextLine();
        calcValue(firstVal, secondVal, operation);
    }
    public static void calcValue(int a, int b, String c) {
        int result;
        switch (c) {
            case ("+"):
                result = a + b;
                System.out.println(result);
                break;
            case ("-"):
                result = a - b;
                System.out.println(result);
            case ("*"):
                result = a * b;
                System.out.println(result);
            case ("/"):
                if (b == 0){
                    System.out.println("На ноль денлить нельзя");
                }
                else {
                    result = a / b;
                    System.out.println(result);
                }
        }
    }
}
