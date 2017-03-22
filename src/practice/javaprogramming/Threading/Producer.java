package practice.javaprogramming.Threading;

import java.util.Date;

class Producer implements Runnable {
	Message queue;

	public Producer(Message queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println("producer thread");
		try {
			while ( true ) {
				putMessage();
				Thread.sleep( 1000 );
			}
		} 
		catch( InterruptedException e ) { }
	}

	private void putMessage() throws InterruptedException
	{	
		synchronized (queue) {
			while (queue.getMessages().size() == Message.MAXQUEUE ){
				queue.wait();
			}
			queue.getMessages().add(new Date().toString() );
			queue.notifyAll();
		}
	}
}