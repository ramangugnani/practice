package practice.leetcode.problems;

public class PartitioningIntoMinimumNumber_1689 {

    public static void main(String[] args) {
        System.out.println(minPartitions("32"));
        
        System.out.println(minPartitions("82734"));
        
        System.out.println(minPartitions("27346209830709182346"));

    }

    public static int minPartitions(String n) {
        Integer result = 0;
        for(char ch : n.toCharArray()) {
            if(result == 9)
                return result;
            result = Math.max(result, ch - '0');
        }
        return result;
    }
}
