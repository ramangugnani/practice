package practice.leetcode.problems;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class LFUCache_460 {

    private Map<Integer, MyCache> cache = null;
    private Queue<MyCache> q = null;
    private Integer capacity = null;
    private Integer stamp = 0;

    public LFUCache_460(int capacity) {
        if (capacity > 0) {
            cache = new HashMap<>(capacity);
            q = new PriorityQueue<>(capacity, new MyComp());
        }
        this.capacity = capacity;
    }

    public int get(int key) {
        if (null != cache && cache.containsKey(key)) {
            //System.out.println("peekgb " + q.peek());
            MyCache obj = cache.get(key);
            // increase the frequency
            q.remove(obj);
            MyCache newObj = new MyCache();
            newObj.key = obj.key;
            newObj.value = obj.value;
            newObj.freq = obj.freq + 1;
            newObj.stamp = stamp++;
            q.add(newObj);
            cache.put(key, newObj);
            //System.out.println(key + " --> " + q);
            //System.out.println("peekga " + q.peek());
            return newObj.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (null == cache) {
            return;
        }
        if (cache.containsKey(key)) {
            MyCache obj = cache.get(key);
            // increase the frequency
            q.remove(obj);
            MyCache newObj = new MyCache();
            newObj.key = key;
            newObj.value = value;
            newObj.freq = obj.freq + 1;
            newObj.stamp = stamp++;
            q.add(newObj);
            cache.put(key, newObj);
            //System.out.println(key + "," + value + " --> " + q);
            //System.out.println("peek1 " + q.peek());
        } else {
            if (cache.size() == capacity) {
                MyCache objRem = q.poll();
                cache.remove(objRem.key);
            }
            MyCache newObj = new MyCache();
            newObj.key = key;
            newObj.value = value;
            newObj.freq = 1;
            newObj.stamp = stamp++;
            cache.put(key, newObj);
            q.add(newObj);
            //System.out.println(key + "," + value + " --> " + q);
            //System.out.println("peek2 " + q.peek());
        }
    }

    public static class MyCache {
        public int key;
        public int value;
        public int freq;
        public int stamp;

        /*
         * (non-Javadoc)
         * 
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "MyCache [key=" + key + ", value=" + value + ", freq=" + freq + ", stamp=" + stamp + "]";
        }

    }

    public static class MyComp implements Comparator<MyCache> {
        @Override
        public int compare(MyCache o1, MyCache o2) {
            int ans = o1.freq - o2.freq;
            if (ans == 0) {
                ans = o1.stamp - o2.stamp;
            }
            return ans;
        }
    }
}
