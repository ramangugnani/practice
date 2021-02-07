package practice.leetcode.problems;

public class NumberOf1Bits_191 {
    public static void main(String[] args) {
        System.out.println(hammingWeight(11));

        System.out.println(hammingWeight(128));

        System.out.println(hammingWeight(-3));

        System.out.println(hammingWeightNew(11));

        System.out.println(hammingWeightNew(128));

        System.out.println(hammingWeightNew(-3));

    }

    public static int hammingWeight(int n) {
        String str = Integer.toBinaryString(n);
        Integer count = 0;
        for (Character ch : str.toCharArray()) {
            if (ch == '1') {
                count++;
            }
        }
        return count;
    }

    public static int hammingWeightNew(int n) {
        int mask = 1;
        Integer count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }
}
