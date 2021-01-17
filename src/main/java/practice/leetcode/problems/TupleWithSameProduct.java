package practice.leetcode.problems;

import java.util.ArrayList;

public class TupleWithSameProduct {

    public static void main(String[] args) {
        System.out.println("=== 1 ===");
        System.out.println(tupleSameProduct(new int[] { 2, 3, 4, 6 }));
        System.out.println("=== 1 ===");
        System.out.println(tupleSameProduct(new int[] { 1, 2, 4, 5, 10 }));
        System.out.println("=== 1 ===");
        System.out.println(tupleSameProduct(new int[] { 2, 3, 4, 6, 8, 12 }));
        System.out.println("=== 1 ===");
        System.out.println(tupleSameProduct(new int[] { 2, 3, 5, 7 }));
        System.out.println("=== 1 ===");
        System.out
                .println(tupleSameProduct(new int[] { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192 }));

    }

    public static int tupleSameProduct(int[] nums) {
        return backtrack(nums, new ArrayList<Integer>(), 0);
    }

    private static int backtrack(int[] nums, ArrayList<Integer> arrayList, Integer index) {
        if (arrayList.size() == 4) {
            if (arrayList.get(0) * arrayList.get(1) == arrayList.get(2) * arrayList.get(3)) {
                System.out.println(arrayList);
                return 1;
            }
        }
        Integer answer = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!arrayList.contains(nums[i])) {
                arrayList.add(nums[i]);
                answer += backtrack(nums, arrayList, index + 1);
                arrayList.remove(arrayList.size() - 1);
            }
        }
        return answer;
    }
}
