package leetcode;

public class RomanToInt2 {
    public static void main(String[] args) {
        System.out.println(romanToInt("xix"));
    }


    public static int romanToInt(String s) {
        int ans = 0, num = 0;
        for(int i=s.length()-1;i>=0;i--){
            char ch = s.toUpperCase().charAt(i);
            num = switch (ch) {
                case 'I' -> 1;
                case 'V' -> 5;
                case 'X' -> 10;
                case 'L' -> 50;
                case 'C' -> 100;
                case 'D' -> 500;
                case 'M' -> 1000;
                default -> num;
            };
            if(4*num<ans)
                ans-=num;
            else
                ans+=num;
        }
        return ans;
    }
}
