package leetcode;

import java.util.HashMap;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(romanToInt("XVIIi"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("MCMXCIV"));

    }


//    I can be placed before V (5) and X (10) to make 4 and 9.
//    X can be placed before L (50) and C (100) to make 40 and 90.
//    C can be placed before D (500) and M (1000) to make 400 and 900.


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
                if (i + 1 < chars.length) {

                    switch (buf) {
                        case "I" -> {
                            if (String.valueOf(chars[i + 1]).equalsIgnoreCase("V") || String.valueOf(chars[i + 1]).equalsIgnoreCase("X")) {
                                sum += (romanValues.get(String.valueOf(chars[i + 1])) - romanValues.get(buf));
                                i++;
                            } else {
                                sum += romanValues.get(buf);
                            }
                        }
                        case "X" -> {
                            if (String.valueOf(chars[i + 1]).equalsIgnoreCase("L") || String.valueOf(chars[i + 1]).equalsIgnoreCase("C")) {
                                sum += (romanValues.get(String.valueOf(chars[i + 1])) - romanValues.get(buf));
                                i++;
                            } else {
                                sum += romanValues.get(buf);
                            }
                        }
                        case "C" -> {
                            if (String.valueOf(chars[i + 1]).equalsIgnoreCase("D") || String.valueOf(chars[i + 1]).equalsIgnoreCase("M")) {
                                sum += (romanValues.get(String.valueOf(chars[i + 1])) - romanValues.get(buf));
                                i++;
                            } else {
                                sum += romanValues.get(buf);
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
