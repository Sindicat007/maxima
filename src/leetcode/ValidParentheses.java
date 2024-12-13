package leetcode;


public class ValidParentheses {
    public static void main(String[] args) {
        String c = "(())";
        System.out.println(isValid(c));
    }

    public static boolean isValid(String s) {
        char[] history = new char[s.length()];
        int count = -1;

        for (char val : s.toCharArray()) {
            if (val == '(' || val == '[' || val == '{') {
                history[++count] = val;
            } else {
                if (count == -1 ||
                        val == ')' && history[count] != '(' ||
                        val == ']' && history[count] != '[' ||
                        val == '}' && history[count] != '{'
                ) {
                    return false;
                }
                count--;
            }
        }
        return count == -1;
    }
}
