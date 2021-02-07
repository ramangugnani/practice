package practice.interview.microsoft;

import java.util.HashMap;
import java.util.Map;

public class LeaderElection {
	public static void main(String[] args) {
		String[] votes = new String[]{"abc","def","abc","def","dgf","dgf"};
		String leader= leaderElection(votes);
		System.out.println(leader);
	}

	private static String leaderElection(String[] votes) {
		String leader = null;
		Integer voteCount = 0;
		Map<String,Integer> voteByCount = new HashMap<>(); 
		for(String vote : votes){
			if(voteByCount.containsKey(vote)){
				voteByCount.put(vote, voteByCount.get(vote)+1);
			}else{
				voteByCount.put(vote,1);
			}
		}

		for(Map.Entry<String, Integer> entry : voteByCount.entrySet()){
			if(entry.getValue() > voteCount){
				leader = entry.getKey();
				voteCount =  entry.getValue();
			}else if(entry.getValue() == voteCount){
				if(entry.getKey().compareTo(leader) > 0){
					leader = entry.getKey();
				}
			}
		}
		return leader;
	}
}
