package r.w.practice.dp;

public class Fibonacci {

    public static void main(String[] args) {

        final int fib1 = fib(1);
        System.out.println("fib1 = " + fib1);
        final int fib2 = fib(2);
        System.out.println("fib2 = " + fib2);
        final int fib4 = fib(4);
        System.out.println("fib4 = " + fib4);
    }

    private static int fib(int n) {

        if (n <= 0) {
            throw new IllegalArgumentException(n + " is invalid");
        }
        if (n <= 2) {
            return 1;
        }
        int f0 = 1, f1 = 1, i = 2;
        while (i < n) {
            int tmp = f0;
            f0 = f1;
            f1 = f1 + tmp;
            ++i;
        }
        return f1;
    }
}
