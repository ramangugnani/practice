package practice.leetcode.problems;

import java.util.concurrent.Semaphore;

class Foo {

    Semaphore run2, run3;

    public Foo() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {

        // printFirst.run() outputs "first". Do not change or remove this line.
        // System.out.println("1_1");
        printFirst.run();
        // System.out.println("1_2");
        run2.release();
        // System.out.println("1_3");
    }

    public void second(Runnable printSecond) throws InterruptedException {

        // printSecond.run() outputs "second". Do not change or remove this line.
        // System.out.println("2_1");
        run2.acquire();
        // System.out.println("2_2");
        printSecond.run();
        // System.out.println("2_3");
        run3.release();
        // System.out.println("2_4");
    }

    public void third(Runnable printThird) throws InterruptedException {

        // System.out.println("3_1");
        run3.acquire();
        // System.out.println("3_2");
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
        // System.out.println("3_3");
    }
}