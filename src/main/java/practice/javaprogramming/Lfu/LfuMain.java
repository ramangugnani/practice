package practice.javaprogramming.Lfu;

public class LfuMain {
	public static void main(String[] args) {
		LeastFrquentlyUsed cache = new LeastFrquentlyUsed(3);
		cache.put(1);
		cache.put(2);
		cache.put(3);
		cache.put(4);
		cache.get(3);
		cache.get(4);
		cache.contains(2);
		cache.put(2);
		cache.contains(2);
	}
}
