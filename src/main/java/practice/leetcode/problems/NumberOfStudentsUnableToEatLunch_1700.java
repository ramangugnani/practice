package practice.leetcode.problems;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class NumberOfStudentsUnableToEatLunch_1700 {

    public static void main(String[] args) {
        System.out.println(countStudents(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));

        System.out.println(countStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));

    }

    public static int countStudents(int[] students, int[] sandwiches) {

        Queue<Integer> studentQ = new LinkedList<>();
        for (int i = 0; i < students.length; i++) {
            studentQ.add(students[i]);
        }

        Stack<Integer> sandwichStack = new Stack<>();
        for (int i = sandwiches.length - 1; i >= 0; i--) {
            sandwichStack.add(sandwiches[i]);
        }

        // System.out.println(studentQ);
        // System.out.println(sandwichStack);

        while (sandwichStack.size() > 0) {
            Integer topSanwich = sandwichStack.peek();
            // System.out.println("topSanwich " + topSanwich);
            Boolean topSanwichEaten = false;
            for (int i = 0; i < students.length; i++) {
                Integer student = studentQ.poll();
                // System.out.println("student " + student);
                if (topSanwich.equals(student)) {
                    // if sandwich can be eaten remove the sandwich
                    sandwichStack.pop();
                    topSanwichEaten = true;
                    break;
                } else {
                    // add the student in the back
                    studentQ.add(student);
                }
            }
            if (topSanwichEaten == false) {
                break;
            }
        }

        return studentQ.size();
    }
}
