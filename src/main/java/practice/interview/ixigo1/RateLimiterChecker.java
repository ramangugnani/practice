package practice.interview.ixigo1;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RateLimiterChecker {

	private static RateLimiterChecker rateLimiterChecker = null;

	private static Map<String,RateLimiterHead> ipApiByRateLimiter = null;

	private static final Long DELAY = 600l; //600 seconds

	private static final Integer MAX_HITS = 5;
	
	private RateLimiterChecker(){
		ipApiByRateLimiter = new ConcurrentHashMap<>();
	}

	RateLimiterChecker getInstance(){
		if(null == rateLimiterChecker){
			synchronized (RateLimiterChecker.class) {
				if(null == rateLimiterChecker){
					rateLimiterChecker = new RateLimiterChecker();
				}
			}
		}
		return rateLimiterChecker;
	}

	synchronized boolean isAllowed(String ip,String api,Long timestamp){
		String key = ip+api;
		RateLimiterHead headNode = ipApiByRateLimiter.get(key);
		if(null == headNode){
			headNode = new RateLimiterHead();
			ipApiByRateLimiter.put(api,headNode);
		}
		if(headNode.isBlocked && (timestamp - headNode.blockedTime) <= DELAY )
			return false;
		else{
			if(headNode.isBlocked){
				headNode.hits.clear();
				headNode.isBlocked = true;
			}
			//current node is existing node or new node
			RateLimiterNode node = null;
			if(headNode.hits.size() == 0 ){
				node = new RateLimiterNode(timestamp);
				//add new node
				headNode.hits.add(0, node);
			}else{
				if(headNode.hits.get(0).timestamp > timestamp){
					node = new RateLimiterNode(timestamp);
					node.hits = headNode.hits.get(0).hits +1;
					//add new node
					headNode.hits.add(0, node);
				}else if(headNode.hits.get(0).timestamp == timestamp){
					node =  headNode.hits.get(0);
					node.hits++;
				}
			}
			//remove extra nodes if present
			Iterator<RateLimiterNode> iterator = headNode.hits.iterator();
			while(iterator.hasNext()){
				RateLimiterNode iteration = iterator.next(); 
				if(iteration.timestamp - node.timestamp > DELAY){
					//Reducing the number of hits and removing the node
					node.hits = node.hits - iteration.hits;
					iterator.remove();
				}
			}

			if(node.hits > MAX_HITS){
				headNode.isBlocked = true;
				headNode.blockedTime = timestamp;
				return false;
			}else{
				return true;				
			}
		}
	}
}
