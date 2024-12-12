package leetcode;


public class ValidParentheses {
    public static void main(String[] args) {
        String c = "[(])";
        System.out.println(isValid(c));
    }

    public static boolean isValid(String s) {
        int buf = 0;
        int count = 0;
        char[] c = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            buf = switch (c[i]) {
                case '[' -> count += 1;
                case '(' -> count += 2;
                case '{' -> count += 3;
                case ']' -> count -= 1;
                case ')' -> count -= 2;
                case '}' -> count -= 3;
                default -> buf;
            };
        }
        return count == 0;
    }
}
