package practice.leetcode.problems;

import java.util.Arrays;

public class BoatsToSavePeople_881 {
    public static void main(String[] args) {
        System.out.println(numRescueBoats(new int[] { 1, 2 }, 3));

        System.out.println(numRescueBoats(new int[] { 3, 2, 2, 1 }, 3));

        System.out.println(numRescueBoats(new int[] { 3, 5, 3, 4 }, 5));

    }

    public static int numRescueBoats(int[] people, int limit) {
        Integer start = 0;
        Integer end = people.length - 1;
        Integer answer = 0;
        Arrays.sort(people);
        while (start <= end) {
            answer++;
            if (people[end] + people[start] <= limit) {
                start++;
            }
            end--;
        }
        return answer;
    }
}
