package leetcode;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] str) {
        if (str == null || str.length < 1) {
            return "";
        }
        String buf = str[0];

        for (String s : str) {
            while (s.indexOf(buf) != 0) {
                buf = buf.substring(0, buf.length() - 1);
                if (buf.isEmpty()) return "";
            }
        }
        return buf;
    }
}
