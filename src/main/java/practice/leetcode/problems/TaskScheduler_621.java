package practice.leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler_621 {

	public static void main(String[] args) {
		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 2));

		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'B', 'B', 'B' }, 0));

		System.out.println(leastInterval(new char[] { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' }, 2));

	}

	public static int leastInterval(char[] tasks, int n) {
		if (n < 1) {
			return tasks.length;
		}
		Queue<Character> q = new LinkedList<>();
		for (int i = 0; i < n; i++) {
			q.add(null);
		}
		PriorityQueue<MyNode> pQ = new PriorityQueue<>(new MyNodeComp());
		Map<Character, MyNode> map = new HashMap<>();
		for (int i = 0; i < tasks.length; i++) {
			if (map.containsKey(tasks[i])) {
				MyNode oldNode = map.get(tasks[i]);
				pQ.remove(oldNode);
				MyNode node = new MyNode();
				node.ch = tasks[i];
				node.freq = oldNode.freq + 1;
				map.put(tasks[i], node);
				pQ.add(node);
			} else {
				MyNode node = new MyNode();
				node.ch = tasks[i];
				node.freq = 1;
				map.put(tasks[i], node);
				pQ.add(node);
			}

		}
		int ans = 0;
		while (pQ.size() > 0) {
			List<MyNode> polledElements = new ArrayList<>();
			Boolean valueAdded = false;
			while (pQ.size() > 0) {
				MyNode node = pQ.poll();
				if (q.contains(node.ch)) {
					polledElements.add(node);
				} else {
					q.add(node.ch);
					node.freq--;
					if (node.freq > 0) {
						polledElements.add(node);
					}
					valueAdded = true;
					break;
				}
			}
			if (!valueAdded) {
				q.add(null);
			}
			//System.out.println(q);
			// remove 1st element now to make window smaller
			q.poll();
			// add all polled elements back
			for (MyNode node : polledElements) {
				pQ.add(node);
			}
			ans++;
		}
		return ans;
	}

	public static class MyNode {
		char ch;
		int freq;
	}

	public static class MyNodeComp implements Comparator<MyNode> {

		@Override
		public int compare(MyNode o1, MyNode o2) {
			return o2.freq - o1.freq;
		}

	}
}
