package practice.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class LoggerRateLimiter_359 {
    int limiter = 10;
    Map<String,Integer> myMap = null;
    /** Initialize your data structure here. */
    public LoggerRateLimiter_359() {
        myMap = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        //System.out.println(myMap);
        if(myMap.containsKey(message)) {
            int oldTimestamp = myMap.get(message);
            if(timestamp - oldTimestamp >= 10) {
                myMap.put(message, timestamp);
                return true;
            }else {
                return false;
            }
        }else {
            myMap.put(message, timestamp);
            return true;
        }
    }
}
