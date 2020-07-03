package de.defdesign.friday;

public class statischeMethoden {
	public static void main(String[] args) {
		Thread th = Thread.currentThread();
		System.out.println(th);
		Thread.yield();
		// Thread.sleep(123);
		th.setPriority(1);
	}
}
