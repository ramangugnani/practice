package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_78 {

    public static void main(String[] args) {
        List<List<Integer>> subSets = subsets(new int[] { 1, 2, 3 });
        System.out.println("Output");
        for (List<Integer> subSet : subSets) {
            System.out.println(subSet);
        }
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        bfs(answer, new ArrayList<>(), nums, 0);
        return answer;
    }

    private static void bfs(List<List<Integer>> answer, ArrayList<Integer> arrayList, int[] nums, int index) {
        answer.add(new ArrayList<>(arrayList));
        for (int i = index; i < nums.length; i++) {
            arrayList.add(nums[i]);
            bfs(answer, arrayList, nums, i + 1);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
