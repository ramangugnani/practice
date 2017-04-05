package practice.interview.ixigo1;

import java.util.ArrayList;
import java.util.List;

public class RateLimiterHead {
	Long blockedTime ;
	Boolean isBlocked = false;
	List<RateLimiterNode> hits = new ArrayList<RateLimiterNode>();
}
