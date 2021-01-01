package practice.leetcode.problems;

public class FibonacciNumber_509 {
    public static void main(String[] args) {
        System.out.println(fib(2));
        System.out.println(fib(3));
        System.out.println(fib(4));
        System.out.println(fib(5));
        
    }

    public static int fib(int n) {
        if(n == 0) {
            return 0;
        }
        if(n <= 2) {
            return 1;
        }
        int oldOld = 1;
        int old = 1;
        int fib = 0;
        for(int i = 3; i <=n ; i++) {
            fib = old + oldOld;
            oldOld = old;
            old = fib;
        }
        return fib;
    }
}
