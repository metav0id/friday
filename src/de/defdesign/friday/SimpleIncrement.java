package de.defdesign.friday;

import java.util.concurrent.atomic.AtomicInteger;

public class SimpleIncrement {
	
	// volatile static int count;
	static AtomicInteger count = new AtomicInteger();
	
	public static void main(String[] args) {
		Runnable target = () -> {
			for(int i=0; i<100000; i++) {
				count.incrementAndGet();
				// count++;
			}
		};
		
		Thread th = new Thread(target);
		Thread th2 = new Thread(target);
		Thread th3 = new Thread(target);
		
		th.start();
		th2.start();
		th3.start();
		
		// System.out.println(count);
		
		try {
			th.join();
			th2.join();
		} catch (InterruptedException ie) {
			
		}
		
		System.out.println(count.get());
	}
	

}
