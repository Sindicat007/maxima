import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int [] arrayTask = {1, 3, 2, 5, 7, 21, 3, 4, 9, 12};
        Arrays.sort(arrayTask);
        for (int i = 0; i < arrayTask.length; i++){
            System.out.println(arrayTask[i]);
        }
    }
    public static void sorting(int[] arr) {
        if(arr.length == 0){
            System.out.println("Массив не содержит элементы");
        }
        else if(arr.length == 1){
            System.out.println("Массив не нуждается в сортировке, так как содержит 1 значение");
        }
        else {

        }

    }
}
