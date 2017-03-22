package practice.javaprogramming.Threading;

import java.util.Date;

public class Task implements Runnable{

	@Override
	public void run() {
		for(int k =0 ; k < 10; ++k){
			synchronized (this) {			
				for(int j= 0 ; j <10000;j++)
					System.out.println(new Date());

				try {
					this.wait(1000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
