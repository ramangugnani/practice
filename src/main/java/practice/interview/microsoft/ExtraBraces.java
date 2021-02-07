package practice.interview.microsoft;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ExtraBraces {
    public static void main(String[] args) {
        System.out.println(removeBraces("(a+(b*c))"));
        System.out.println(removeBraces("((a)+(b))"));
        System.out.println(removeBraces(""));
        System.out.println(removeBraces("((a+b))"));

    }

    public static List<List<Integer>> removeBraces(String input) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (null == input) {
            return ans;
        }
        char[] myChar = input.toCharArray();
        Stack<MyNode> myStack = new Stack<>();
        for (int index = 0; index < myChar.length; index++) {
            if (myChar[index] != ')') {
                MyNode node = new MyNode();
                node.ch = myChar[index];
                node.index = index;
                myStack.push(node);
            } else {
                Boolean operatorPresent = false;

                while (myStack.size() > 0) {
                    MyNode node = myStack.pop();
                    if (node.ch == '+' || node.ch == '-' || node.ch == '*' || node.ch == '/') {
                        operatorPresent = true;
                    }
                    if (node.ch == '(') {
                        if (operatorPresent == false) {
                            List<Integer> myAns = new ArrayList<>();
                            myAns.add(node.index);
                            myAns.add(index);
                            ans.add(myAns);
                        }
                        break;
                    }
                }
            }

        }
        return ans;
    }

    public static class MyNode {
        public char ch;
        public int index;
    }
}
