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
            int [] resultArray = new int[arr.length];
            int minVal, bufVal;
            minVal = 0;
            int maxVal = Integer.MAX_VALUE;

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] <= minVal) {
                    resultArray[i] = minVal = arr[i];
                }
                else if (arr[i] > minVal){}
            }
        }

    }
//    public static int swapValues(int a, int b) {
//        a = a ^ b;
//        b = a ^ b;
//        a = a ^ b;
//        return
//    }
}
