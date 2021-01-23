package practice.leetcode.problems;

import java.util.Stack;

public class MinStack_155 {
    /** initialize your data structure here. */
    private Stack<MyData> myStack;

    public MinStack_155() {
        myStack = new Stack<>();
    }

    public void push(int x) {
        MyData data = new MyData();
        data.data = x;
        if (myStack.size() > 0) {
            data.minData = Math.min(myStack.peek().minData, x);
        } else {
            data.minData = x;
        }
        myStack.push(data);
    }

    public void pop() {
        myStack.pop();
    }

    public int top() {
        return myStack.peek().data;
    }

    public int getMin() {
        return myStack.peek().minData;
    }

    public class MyData {
        int data;
        int minData;
    }
}
