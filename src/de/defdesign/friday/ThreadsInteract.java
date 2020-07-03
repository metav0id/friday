package de.defdesign.friday;

public class ThreadsInteract {
	
	public static void main(String[] args) {
		Runnable target = () -> {
			Thread t = Thread.currentThread();
			
			while (true) {
				System.out.println("Läuft ....");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ie) {
					ie.printStackTrace();
					System.out.println(t.getName() + " wird beendet");
					break;
				}
			}
		};
		
		Thread th = new Thread(target);
		th.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException ie) {
			
		}
		
		System.out.println("Main setzt th-Thread auf Interrupted!");
		th.interrupt();
		
		
	}

}
