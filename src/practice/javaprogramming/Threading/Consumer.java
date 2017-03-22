package practice.javaprogramming.Threading;

class Consumer implements Runnable {
	Message queue;
	
	private int counter = 0;

	Consumer(Message queue) {
		this.queue = queue;
	}

	public void run() {
		System.out.println("consumer thread");
		try {
			Thread.sleep( 2000 );
			while ( true ) {
				String message = getMessage();
				System.out.println("Got message: " + message+ " "+(counter++)+" " +Thread.currentThread().getName());
				Thread.sleep(1000 );
			}
		} 
		catch( InterruptedException e ) {

		}
	}

	public String getMessage() throws InterruptedException
	{
		synchronized (queue) {			
			while (queue.getMessages().size() == 0 ){
				queue.wait();
			}
			String message = (String)queue.getMessages().get(0);
			queue.getMessages().remove( message );
			queue.notifyAll();
			return message;
		}

	}

	public static void main(String args[]) {
		System.out.println("starting application");
		Message quMessage = new Message();

		Producer producer = new Producer(quMessage);
		Thread t1 = new Thread(producer);
		t1.setName("producer");
		t1.start();

		Consumer consumer1 = new Consumer(quMessage);
		Thread t2 = new Thread(consumer1);
		t2.setName("consumer1");
		t2.start();

		Consumer consumer2 = new Consumer(quMessage);
		Thread t3 = new Thread(consumer1);
		t3.setName("consumer2");
		t3.start();
	}
}