package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII_90 {

    public static void main(String[] args) {
        List<List<Integer>> subSets = subsetsWithDup(new int[] { 1, 2, 2 });
        System.out.println("Output");
        for (List<Integer> subSet : subSets) {
            System.out.println(subSet);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        bfs(answer, new ArrayList<>(), nums, 0);
        return answer;
    }

    private static void bfs(List<List<Integer>> answer, ArrayList<Integer> arrayList, int[] nums, int index) {
        answer.add(new ArrayList<>(arrayList));
        for (int i = index; i < nums.length; i++) {
            if(i > index && nums[i] == nums[i-1]) continue; // skip duplicates

            arrayList.add(nums[i]);
            bfs(answer, arrayList, nums, i + 1);
            arrayList.remove(arrayList.size() - 1);
        }
    }
}
