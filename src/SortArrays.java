public class SortArrays {
       public static void main(String[] args) {
        int[] arrayTask = new int[]{12, 3, 2, 5, 7, 21, 3, 4, 9, 24};

        long startTime = System.nanoTime();
        sortArr(arrayTask);
        for(int i = 0; i < arrayTask.length - 1; ++i) {
            System.out.println(arrayTask[i]);
        }
        long endTime = System.nanoTime();

        long timeElapsed = endTime - startTime;
        System.out.print(timeElapsed);
    }

    public static void sortArr(int[] arr) {
        if (arr.length == 0) {
            System.out.println("Массив не содержит эллементов");
        } else if (arr.length == 1) {
            System.out.println("Массив не нуждается в сортировке, так как содержит 1 эллемент");
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
