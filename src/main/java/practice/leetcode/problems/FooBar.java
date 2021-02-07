package practice.leetcode.problems;

public class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    private volatile int lock = 0;

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true) {
                if (lock == 1) {
                    Thread.sleep(1);
                } else {
                    // printFoo.run() outputs "foo". Do not change or remove this line.
                    printFoo.run();
                    lock = 1;
                    break;
                }
            }

        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            while (true) {
                if (lock == 0) {
                    Thread.sleep(1);
                } else {
                    // printBar.run() outputs "bar". Do not change or remove this line.
                    printBar.run();
                    lock = 0;
                    break;
                }
            }
        }
    }
}
