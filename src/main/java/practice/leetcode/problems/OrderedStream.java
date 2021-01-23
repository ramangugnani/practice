package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.List;

class OrderedStream {
    private List<String> myList = null;
    private Integer curPos = -1;

    public OrderedStream(int n) {
        myList = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            myList.add(null);
        }
    }

    public List<String> insert(int id, String value) {
        //System.out.println(curPos + " " + myList);
        myList.set(id - 1, value);

        List<String> ans = new ArrayList<>();
        for (int i = curPos + 1; i < myList.size(); i++) {
            String order = myList.get(i);
            if (null == order) {
                break;
            } else {
                ans.add(order);
                curPos++;
            }
        }
        return ans;
    }
}
