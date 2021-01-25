package practice.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author ramangugnani
 * 
 * 
 */
public class Careem {

    public static Map<String, Set<Integer>> emailAddressByUserId = new HashMap<>();
    
    public static Integer maxSetId = 0;

    public static void main(String[] args) {

        Map<Integer, List<String>> userIdByEmailIds = new HashMap<>();

        userIdByEmailIds.put(1, new ArrayList<>(Arrays.asList("a", "b")));
        userIdByEmailIds.put(2, new ArrayList<>(Arrays.asList("c", "d")));
        userIdByEmailIds.put(3, new ArrayList<>(Arrays.asList("d", "a")));

        System.out.println("========== INPUT ==========");
        System.out.println(userIdByEmailIds);
        System.out.println("========== OUTPUT ==========");
        List<Set<Integer>> result = getDuplicates(userIdByEmailIds);
        System.out.println(result);
        
        userIdByEmailIds.clear();
        userIdByEmailIds.put(1, new ArrayList<>(Arrays.asList("a", "b")));
        userIdByEmailIds.put(2, new ArrayList<>(Arrays.asList("b", "c")));
        userIdByEmailIds.put(3, new ArrayList<>(Arrays.asList("d")));

        System.out.println("========== INPUT ==========");
        System.out.println(userIdByEmailIds);
        System.out.println("========== OUTPUT ==========");
        result = getDuplicates(userIdByEmailIds);
        System.out.println(result);
        
        
    }

    public static List<Set<Integer>> getDuplicates(Map<Integer, List<String>> userIdByEmailIds) {
        Map<String, MySet> emailIdByMySet = new HashMap<>();
        Map<Integer, MySet> idByMySet = new HashMap<>();
        
        for(Map.Entry<Integer, List<String>> entry : userIdByEmailIds.entrySet()) {
            
            //System.out.println("PROCESSING entry " + entry);
            //System.out.println("PROCESSING emailIdByMySet " + emailIdByMySet);
            //System.out.println("PROCESSING idByMySet " + idByMySet);

            List<Integer> distinctSet = new ArrayList<>();
            for(String emailId  : entry.getValue()) {
                if(emailIdByMySet.containsKey(emailId)) {
                    distinctSet.add(emailIdByMySet.get(emailId).id);
                }
            }
            
            // if distinct Set has data join those sets
            if(distinctSet.size() > 0){
                //System.out.println("distinctSets  "+ distinctSet);
                MySet myset = new MySet();
                myset.id = maxSetId++;
                myset.userId = new HashSet<>();
                myset.userId.add(entry.getKey());
                myset.emailIds = new HashSet<>(entry.getValue());
                
                for(int i : distinctSet) {
                    MySet set = idByMySet.get(i);
                    // merge into baseSet
                    myset.userId.addAll(set.userId);
                    myset.emailIds.addAll(set.emailIds);
                    idByMySet.remove(set.id);
                }
                myset.userId.add(entry.getKey());
                myset.emailIds.addAll(entry.getValue());

                idByMySet.put(myset.id, myset);
                for(String mailId : myset.emailIds) {
                    emailIdByMySet.put(mailId, myset);
                }
                
                //System.out.println("PROCESSED emailIdByMySet " + emailIdByMySet);
                //System.out.println("PROCESSED idByMySet " + idByMySet);
            }
            // else create new set
            else {
                MySet myset = new MySet();
                myset.id = maxSetId++;
                myset.userId = new HashSet<>();
                myset.userId.add(entry.getKey());
                myset.emailIds = new HashSet<>(entry.getValue());
                idByMySet.put(myset.id, myset);
                for(String mailId : myset.emailIds) {
                    emailIdByMySet.put(mailId, myset);
                }
                //System.out.println("New Set "+ myset.toString());
            }
            
            //System.out.println("\n\n\n");
        }
        List<Set<Integer>> result = new ArrayList<>();
        for(Map.Entry<Integer, MySet> entry : idByMySet.entrySet()) {
            result.add(entry.getValue().userId);
        }
        return result;
    }
    
    public static class MySet{
        public Integer id;
        public Set<Integer> userId;
        public Set<String> emailIds;
        /* (non-Javadoc)
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return "MySet [id=" + id + ", userId=" + userId + ", emailIds=" + emailIds + "]";
        }
        
        
    }

}
