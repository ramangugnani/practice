package practice.leetcode.problems;

public class CheckIfTwoStringArraysAreEquivalent_1662 {
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[] { "ab", "c" }, new String[] { "a", "bc" }));

        System.out.println(arrayStringsAreEqual(new String[] { "a", "cb" }, new String[] { "ab", "c" }));

        System.out.println(arrayStringsAreEqual(new String[] { "abc", "d", "defg" }, new String[] { "abcddefg" }));

        System.out.println(arrayStringsAreEqual(new String[] { "" }, new String[] { "" }));
        
        System.out.println(arrayStringsAreEqualNew(new String[] { "ab", "c" }, new String[] { "a", "bc" }));

        System.out.println(arrayStringsAreEqualNew(new String[] { "a", "cb" }, new String[] { "ab", "c" }));

        System.out.println(arrayStringsAreEqualNew(new String[] { "abc", "d", "defg" }, new String[] { "abcddefg" }));

        System.out.println(arrayStringsAreEqualNew(new String[] { "" }, new String[] { "" }));

    }

    public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        Integer itr1 = 0;
        Integer itr2 = 0;
        Integer index1 = 0;
        Integer index2 = 0;
        Boolean eof1 = false;
        Boolean eof2 = false;

        // if any of the string reaches the end , loop should break;
        while (!(eof1 ^ eof2)) {
            // System.out.println("itr1 " + itr1 + " index1 " + index1 + " eof1 " + eof1);
            // System.out.println("itr2 " + itr2 + " index2 " + index2 + " eof2 " + eof2);

            if (itr1 >= word1.length && itr2 >= word2.length) {
                return true;
            }
            if (index1 >= word1[itr1].length() && index2 >= word2[itr2].length()) {
                return true;
            }

            if (word1[itr1].charAt(index1) != word2[itr2].charAt(index2)) {
                return false;
            } else {
                // proceed
                index1++;
                if (index1 >= word1[itr1].length()) {
                    index1 = 0;
                    itr1++;
                    if (itr1 >= word1.length) {
                        eof1 = true;
                    }
                }

                index2++;
                if (index2 >= word2[itr2].length()) {
                    index2 = 0;
                    itr2++;
                    if (itr2 >= word2.length) {
                        eof2 = true;
                    }
                }
            }
        }
        return false;
    }
    
    public static boolean arrayStringsAreEqualNew(String[] word1, String[] word2) {
        
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();

        for (String i : word1)
        {
            string1.append(i);
        }
        
        for (String i : word2)
        {
            string2.append(i);
        }
        
        return String.valueOf(string1).equals(String.valueOf(string2));
    }
}
