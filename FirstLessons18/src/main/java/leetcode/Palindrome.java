package leetcode;

public class Palindrome {

    public static void main(String[] args) {

        int a = 12221;
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(int x) {
        char[] ch = String.valueOf(x).toCharArray();
        StringBuilder str = new StringBuilder().append(ch).reverse();
        return str.toString().equals(String.valueOf(ch));
    }
}
