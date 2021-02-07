package practice.leetcode.problems;

public class DesignCompressedStringIterator_604 {

    private Integer charPos;
    private Integer charCountPos;
    private Integer currentCount;
    private Integer length;
    private char[] myChar;

    DesignCompressedStringIterator_604(String str) {
        this.charPos = 0;
        this.charCountPos = 1;
        this.currentCount = 0;
        this.length = str.length();
        this.myChar = str.toCharArray();
    }

    public Character next() {
        if (charCountPos > length) {
            return null;
        }
        if (currentCount < myChar[charCountPos] - '0') {
            currentCount++;
            return myChar[charPos];
        } else {
            charPos += 2;
            charCountPos += 2;
            currentCount = 0;
            if (charCountPos < length) {
                currentCount++;
                return myChar[charPos];
            } else {
                return null;
            }
        }
    }

    public Boolean hasNext() {
        if (charCountPos > length) {
            return false;
        }
        if (currentCount < myChar[charCountPos] - '0') {
            return true;
        } else {
            if (charCountPos + 1 < length) {
                return true;
            } else {
                return false;
            }
        }
    }
}
