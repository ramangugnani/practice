package practice.interview.ixigo1;

public class RateLimiterNode {
	public RateLimiterNode(Long timestamp) {
		this.timestamp = timestamp;
		this.hits = 0;
	}
	Long timestamp;
	Integer hits;
}
