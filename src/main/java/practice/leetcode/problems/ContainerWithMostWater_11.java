package practice.leetcode.problems;

public class ContainerWithMostWater_11 {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));

        System.out.println(maxArea(new int[] { 1, 1 }));

        System.out.println(maxArea(new int[] { 4, 3, 2, 1, 4 }));

        System.out.println(maxArea(new int[] { 1, 2, 1 }));

    }

    public static int maxArea(int[] height) {
        Integer answer = 0;
        Integer i = 0;
        Integer j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                answer = Math.max(answer, height[i] * (j - i));
                i++;
            } else {
                answer = Math.max(answer, height[j] * (j - i));
                j--;
            }
        }
        return answer;
    }

    public static int maxAreaBrut(int[] height) {
        Integer answer = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                answer = Math.max(answer, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return answer;
    }
}
