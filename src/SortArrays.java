import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class SortArrays {
       public static void main(String[] args) {
//        int[] arrayTask = new int[]{12, 3, 2, 5, 7, 21, 3, 4, 9, 24};
           Scanner scanner = new Scanner(System.in);

           System.out.println("Сколько чисел хотите отсортировать?");
           int howMatchElements = scanner.nextInt();
           int[] arr = new int[howMatchElements];
           System.out.println("Введите " + howMatchElements + " чисел");
           for (int i = 0; i < howMatchElements; i++){
               arr[i] = scanner.nextInt();
           }
        long startTime = System.nanoTime();
        sortArr(arr);
        for(int i = 0; i < howMatchElements; ++i) {
            System.out.println(arr[i]);
        }
        long endTime = System.nanoTime();
        long timeElapsed = endTime - startTime;
        System.out.print("Выполнено за " + timeElapsed + " наносекунд");
    }

    public static void sortArr(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Массив не содержит элементов");
        } else if (arr.length == 1) {
            System.out.println("Массив не нуждается в сортировке, так как содержит 1 элемент");
        } else {
            for(int i = 0; i < arr.length - 1; ++i) {
                for(int k = 0; k < arr.length - i - 1; ++k) {
                    if (arr[k + 1] < arr[k]) {
                        int swap = arr[k];
                        arr[k] = arr[k + 1];
                        arr[k + 1] = swap;
                    }
                }
            }
        }

    }
}
