package leetcode;

import java.util.*;

public class RemoveDuplicatesFromSortedArray {


    public static void main(String[] args) {
        int[] nums = {1, 4, 5, 5, -5, 6, -7, 8, 8, 9,};
        System.out.print(removeDublicate(nums) + " ");
    }

    public static int removeDublicate(int[] numbers) {
        List<Integer> list;
        Set<Integer> set = new HashSet<>();

        for (int number : numbers) {
            set.add(number);
        }
        list = set.stream().sorted().toList();

        Arrays.fill(numbers, 0);
        for (int i = 0; i < list.size(); i++) {
            numbers[i] = list.get(i);
        }

        int k = list.size();
        System.out.println(Arrays.toString(numbers));
        return k;
    }
}
