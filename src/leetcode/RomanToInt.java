package leetcode;

import java.util.HashMap;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("LVIII"));

    }

    public static int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int sum = 0;
        HashMap<String, Integer> romanValues = new HashMap<>();
        romanValues.put("I", 1);
        romanValues.put("V", 5);
        romanValues.put("X", 10);
        romanValues.put("L", 50);
        romanValues.put("C", 100);
        romanValues.put("D", 500);
        romanValues.put("M", 1000);

        for (int i = 0; i < chars.length; i++) {
            String buf = String.valueOf(chars[i]).toUpperCase();
            if (romanValues.containsKey(buf)) {
                if (i != 0) {
                    switch (buf) {
                        case "V", "X" -> {
                            if (String.valueOf(chars[i - 1]).equalsIgnoreCase("I")) {
                                sum += (romanValues.get(buf) - 1);
                            }
                        }
                        case "L", "C" -> {
                            if (String.valueOf(chars[i - 1]).equalsIgnoreCase("X")) {
                                sum += (romanValues.get(buf) - 10);
                            }
                        }
                        case "D", "M" -> {
                            if (String.valueOf(chars[i - 1]).equalsIgnoreCase("C")) {
                                sum += (romanValues.get(buf) - 100);
                            }
                        }
                        default -> {
                                sum += romanValues.get(buf);
                        }
                    }
                } else {
                    sum += romanValues.get(buf);
                }
            }
        }
        return sum;
    }
}
