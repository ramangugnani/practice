package practice.leetcode.problems;

public class PrintInOrder_1114 {
    public static void main(String[] args) throws InterruptedException {
        int[] arr = new int[] { 2, 1, 3 };
        Foo foo = new Foo();
        for (int i = 0; i < arr.length; i++) {
            Thread thread = new Thread(new MyThread(arr[i], foo));
            thread.start();
        }

    }

    public static void createThread(int index, Foo foo) throws InterruptedException {
        switch (index) {
        case 1:
            // System.out.println("M1_1");
            MyThread_1 thread1 = new MyThread_1();
            foo.first(thread1);
            // System.out.println("M1_2");
            break;
        case 2:
            // System.out.println("M2_1");
            MyThread_2 thread2 = new MyThread_2();
            foo.second(thread2);
            // System.out.println("M2_2");
            break;
        case 3:
            // System.out.println("M3_1");
            MyThread_3 thread3 = new MyThread_3();
            foo.third(thread3);
            // System.out.println("M3_2");
            break;
        default:
            break;
        }
        return;
    }

    public static class MyThread_1 implements Runnable {

        @Override
        public void run() {
            System.out.println("first");
        }

    }

    public static class MyThread_2 implements Runnable {

        @Override
        public void run() {
            System.out.println("second");
        }

    }

    public static class MyThread_3 implements Runnable {

        @Override
        public void run() {
            System.out.println("third");
        }

    }

    public static class MyThread implements Runnable {

        public MyThread(int index, Foo foo) {
            this.index = index;
            this.foo = foo;
        }

        int index;
        Foo foo;

        @Override
        public void run() {
            try {
                createThread(index, foo);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
