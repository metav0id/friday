package de.defdesign.friday;

class DeadlockThread extends Thread {

	final static Object m1 = new Object();
	final static Object m2 = new Object();
	
	@Override
	public void run() {
		
		synchronized (m1) {
			System.out.println("meth1");
			
			synchronized (m2) {
				System.out.println("meth1.2");
			}
		}
		
		synchronized (m2) {
			System.out.println("meth2");
			
			synchronized(m1) {
			System.out.println("meth2.2");
		}
		}
	}
	}

public class Deadlock  {
	public static void main(String[] args) {
		new DeadlockThread().start();
		new DeadlockThread().start();
	}
}