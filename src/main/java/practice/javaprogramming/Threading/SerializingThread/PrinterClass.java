package practice.javaprogramming.Threading.SerializingThread;

public class PrinterClass implements Runnable{
	Lock lock;
	int ownNumber ;
	PrinterClass(String name ,Lock lock,Integer ownNumber){
		this.lock = lock;
		this.ownNumber = ownNumber;
		System.out.println("ownNumber"+ownNumber);
	}

	@Override
	public void run() {
		while(true){
			synchronized (lock) {
				if(lock.variable == ownNumber){
					System.out.println(Thread.currentThread().getName() + " -->" + lock.variable);
					lock.variable++;
					ownNumber = ownNumber + 3;
					lock.notifyAll();
				}else{
					try {
						lock.wait();
						Thread.sleep(200);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
