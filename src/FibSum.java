public class FibSum {
    public static void main(String[] args) {
        System.out.println(fibRec(6));
    }

    public static int fibFor(int a) {
        int result = 0;
        int buf1 = 0;
        int buf2 = 1;
        for (int i = 1; i < a; i++) {
            result = buf1 + buf2;
            buf1 = buf2;
            buf2 = result;
        }
        return result;
    }

    public static int fibRec(int a) {
        if (a <= 1) return a;
        return fibRec(a - 1) + fibRec(a - 2);
    }
}
