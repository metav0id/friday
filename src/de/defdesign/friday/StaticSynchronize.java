package de.defdesign.friday;

public class StaticSynchronize {
	
	static class Dec implements Runnable {
		static int count;
		
		synchronized static void decrement() {
			count--;
		}
		
		@Override
		public void run() {
			for (int i=0; i<1000000; i++) {
				decrement();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t1 = new Thread(new Dec());
		Thread t2 = new Thread(new Dec());
		
		t1.start();
		t2.start();
		
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(Dec.count);
		
	}

}
