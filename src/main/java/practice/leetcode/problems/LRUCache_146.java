package practice.leetcode.problems;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_146 {
    int capacity = 0;
    Map<Integer, Integer> map = new HashMap<>();

    public LRUCache_146(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        int value = map.get(key);
        map.remove(key);
        map.put(key, value);
        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            if (map.size() >= capacity) {
                int removeKey = map.keySet().iterator().next();
                map.remove(removeKey);
            }
        }
        map.put(key, value);
    }

}
