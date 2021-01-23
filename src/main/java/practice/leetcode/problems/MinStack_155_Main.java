package practice.leetcode.problems;

public class MinStack_155_Main {
public static void main(String[] args) {
    MinStack_155 minStack = new MinStack_155();
    minStack.push(-2);
    minStack.push(0);
    minStack.push(-3);
    System.out.println(minStack.getMin()); // return -3
    minStack.pop();
    System.out.println(minStack.top());    // return 0
    System.out.println(minStack.getMin()); // return -2
}
}
