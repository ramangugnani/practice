package practice.leetcode.problems;

public class LoggerRateLimiter_359_Main {
    public static void main(String[] args) {

        LoggerRateLimiter_359 logger = new LoggerRateLimiter_359();

        // logging string "foo" at timestamp 1
        System.out.println(logger.shouldPrintMessage(1, "foo")); // returns true;

        // logging string "bar" at timestamp 2
        System.out.println(logger.shouldPrintMessage(2, "bar")); // returns true;

        // logging string "foo" at timestamp 3
        System.out.println(logger.shouldPrintMessage(3, "foo")); // returns false;

        // logging string "bar" at timestamp 8
        System.out.println(logger.shouldPrintMessage(8, "bar")); // returns false;

        // logging string "foo" at timestamp 10
        System.out.println(logger.shouldPrintMessage(10, "foo")); // returns false;

        // logging string "foo" at timestamp 11
        System.out.println(logger.shouldPrintMessage(11, "foo")); // returns true;
    }
}
