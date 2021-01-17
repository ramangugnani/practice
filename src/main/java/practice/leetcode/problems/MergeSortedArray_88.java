package practice.leetcode.problems;

public class MergeSortedArray_88 {
    public static void main(String[] args) {
        int[] nums1 = new int[] { 1, 2, 3, 0, 0, 0 };
        int[] nums2 = new int[] { 2, 5, 6 };
        System.out.print("nums0 ");
        print(nums1);
        System.out.print("nums1 ");
        print(nums2);
        merge(nums1, 3, nums2, 3);
        System.out.print("numsF ");
        print(nums1);

        nums1 = new int[] { 1 };
        nums2 = new int[] {};
        System.out.print("nums0 ");
        print(nums1);
        System.out.print("nums1 ");
        print(nums2);
        merge(nums1, 1, nums2, 0);
        System.out.print("numsF ");
        print(nums1);

        nums1 = new int[] { 0 };
        nums2 = new int[] { 1 };
        System.out.print("nums0 ");
        print(nums1);
        System.out.print("nums1 ");
        print(nums2);
        merge(nums1, 0, nums2, 1);
        System.out.print("numsF ");
        print(nums1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        Integer itr2 = n - 1;
        Integer itr1 = m - 1;
        Integer itrF = nums1.length - 1;

        while (itr1 >= 0 && itr2 >= 0) {
            if (nums1[itr1] > nums2[itr2]) {
                nums1[itrF] = nums1[itr1];
                itr1--;
                itrF--;
            } else {
                nums1[itrF] = nums2[itr2];
                itr2--;
                itrF--;
            }
        }
        if (itr2 >= 0) {
            while (itr2 >= 0) {
                nums1[itrF] = nums2[itr2];
                itr2--;
                itrF--;
            }
        }
    }

    public static void print(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
