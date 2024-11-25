package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Palindrome {

    public static void main(String[] args) {
        int a = 12221;
        System.out.println(isPalindrome(a));


        char[] sym = String.valueOf(a).toCharArray();
        StringBuilder strb = new StringBuilder();
        strb.append(sym);
        System.out.println(strb.reverse());
//        String b = new StringBuilder(sym.toString());
        System.out.println(String.valueOf(sym));
//        System.out.println(isPalindrome(121));

    }

    public static boolean isPalindrome(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        StringBuilder str = new StringBuilder().append(ch).reverse();
        return str.toString().equals(String.valueOf(ch));
    }
}
