import java.util.Scanner;

public class While {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Для подсчета суммы, введите поочередно несколько четных чисел");
        int res = 0;
        while (true){
            int var = scanner.nextInt();
            if (var % 2 == 0) {
                res += var;
            }

            else {
                System.out.println("Сумма введеных чисел: " + res);
                break;
            }
        }
    }
}
