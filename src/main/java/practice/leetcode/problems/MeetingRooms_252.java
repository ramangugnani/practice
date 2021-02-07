package practice.leetcode.problems;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRooms_252 {
    public static void main(String[] args) {
        int[][] input = new int[][] { { 0, 30 }, { 50, 60 }, { 30, 40 } };
        System.out.println(meetingRooms(input));
        input = new int[][] { { 7, 10 }, { 2, 4 } };
        System.out.println(meetingRooms(input));
    }

    public static Boolean meetingRooms(int[][] input) {
        if (input.length == 1) {
            return true;
        }
        Arrays.sort(input, new MyComp());
        for (int i = 1; i < input.length; i++) {
            if (input[i][0] < input[i - 1][1]) {
                return false;
            }
        }
        return true;
    }

    public static class MyComp implements Comparator<int[]> {

        @Override
        public int compare(int[] o1, int[] o2) {
            return o1[0] - o2[0];
        }

    }

}
