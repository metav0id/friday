package de.defdesign.friday;

public class MyRunnable implements Runnable {
	
	@Override
	public void run() {
		for (int i=1; i<4; i++) {
			System.out.println("Run by: " + Thread.currentThread().getName());
		}
	}
	
	public static void main(String[] args) {
		MyRunnable runny = new MyRunnable();
		Thread thready = new Thread(runny);
		Thread thready1 = new Thread(runny);
		Thread thready2 = new Thread(runny);
		
		thready.setName("Alan");
		thready2.setName("Moni");
		thready1.setName("Enrico");
		
		thready.start();
		thready1.start();
		thready2.start();
	}

}
