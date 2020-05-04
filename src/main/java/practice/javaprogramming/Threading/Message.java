package practice.javaprogramming.Threading;

import java.util.ArrayList;
import java.util.List;

public class Message {
	public static final int MAXQUEUE = 5;
	private List<String> messages = new ArrayList<>();

	public synchronized List<String> getMessages() {
		return messages;
	}
	
}
