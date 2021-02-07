package practice.leetcode.problems;

public class PrintFooBarAlternately_1115 {
    public static void main(String[] args) throws InterruptedException {
        FooBar fooBar = new FooBar(5);
        Thread thread = new Thread(new MyThreadF(fooBar));
        Thread thread1 = new Thread(new MyThreadB(fooBar));
        thread.start();
        thread1.start();

    }

    public static class MyThreadF implements Runnable {
        FooBar fooBar;

        public MyThreadF(FooBar fooBar) {
            this.fooBar = fooBar;
        }

        @Override
        public void run() {
            try {
                fooBar.foo(new FooPrint());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    
    public static class MyThreadB implements Runnable {
        FooBar fooBar;

        public MyThreadB(FooBar fooBar) {
            this.fooBar = fooBar;
        }

        @Override
        public void run() {
            try {
                fooBar.bar(new BarPrint());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static class FooPrint implements Runnable {

        @Override
        public void run() {
            System.out.println("foo");
        }

    }

    public static class BarPrint implements Runnable {

        @Override
        public void run() {
            System.out.println("bar");
        }

    }

}
