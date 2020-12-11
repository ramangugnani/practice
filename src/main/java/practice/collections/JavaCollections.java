package practice.collections;

import java.util.*;

public class JavaCollections {
    public static void main(String[] args) {
        
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
        Map<Integer,Integer> myHashMap = new HashMap<>();
        
        //myHashMap.get(1);
        // myHashMap.getOrDefault(1, 1);
        
        Map<Integer,Integer> myTreeMap = new TreeMap<>();
        
        Map<Integer,Integer> myLinkHashSet = new LinkedHashMap<>();
    }
}
