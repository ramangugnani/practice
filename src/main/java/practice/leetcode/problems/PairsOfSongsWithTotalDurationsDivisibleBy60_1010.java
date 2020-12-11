package practice.leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class PairsOfSongsWithTotalDurationsDivisibleBy60_1010 {
    
    public static void main(String[] args) {
        int[] input = new  int[] {30,20,150,100,40};
        System.out.println(numPairsDivisibleBy60(input));
        
        input = new int[] {418,204,77,278,239,457,284,263,372,279,476,416,360,18};
        System.out.println(numPairsDivisibleBy60(input));
    }

    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> myMap = new HashMap<>();
        int answer = 0;
        
        for(int actualSongTime : time) {
            int songTime = actualSongTime % 60;
            
            int altSongTime = 0;
            if (songTime != 0) {
                altSongTime = 60-songTime;
            }
            if(myMap.containsKey(altSongTime)) {
                //System.out.println(actualSongTime + " " + altSongTime);
                answer = answer + myMap.get(altSongTime);
            }
            //System.out.println("Putting " + songTime );
            if(myMap.containsKey(songTime)) {
                myMap.put(songTime, myMap.get(songTime)+1);
            }else {
                myMap.put(songTime, 1);
            }
        }
        return answer;
    }
    
}
