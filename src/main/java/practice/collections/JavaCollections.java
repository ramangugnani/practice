package practice.collections;

import java.util.*;

public class JavaCollections {
    public static void main(String[] args) {

        Queue<Integer> myQueue = new PriorityQueue<>(11, new SortbyInteger());
        myQueue.add(3);

        myQueue.add(2);

        System.out.println(myQueue.poll());

        System.out.println(myQueue.poll());
        
        List<Integer> myList = new ArrayList<>();
        myList.add(3);
        myList.add(1);
        myList.add(2);
        
        Collections.sort(myList,new SortbyInteger());
        
        System.out.println(myList);

    }

    public void collectionList() {
        List<Integer> myList = new ArrayList<>();

        Queue<Integer> myQueue = new PriorityQueue<>();

    }

    public void collectionSet() {
        Set<Integer> myHashSet = new HashSet();

        Set<Integer> myTreeSet = new TreeSet<>();

        Set<MyEnum> myEnumSet = EnumSet.allOf(MyEnum.class);

        Set<Integer> myLinkHashSet = new LinkedHashSet<>();
    }

    public void collectionMap() {
        Map<Integer, Integer> myHashMap = new HashMap<>();

        // myHashMap.get(1);
        // myHashMap.getOrDefault(1, 1);

        Map<Integer, Integer> myTreeMap = new TreeMap<>();

        Map<Integer, Integer> myLinkHashSet = new LinkedHashMap<>();
    }

    public static class SortbyInteger implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
        
    }

}
