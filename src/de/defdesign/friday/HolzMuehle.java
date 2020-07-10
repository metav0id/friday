package de.defdesign.friday;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class HolzMuehle extends Thread {
	
	private static final int MAX_LAGER = 100;
	private String name;
	private int holzmehlbestand = 30;
	
	@Override
	public void run() {
		while (true) {
			produceHolzmehl();
		}
	}
	
	public HolzMuehle (String name) {
		this.name = name;
	}
	
	public int ausliefern(int holzmehlbedarf) {
		int holzlieferung = 0;
		
		Lock lock = new ReentrantLock();
		lock.lock();
		
		
		// synchronized (this) {
		
		try {
			if (this.holzmehlbestand >= holzmehlbedarf) {
				this.holzmehlbestand -= holzmehlbedarf;
				holzlieferung = holzmehlbedarf;
			} else {
				holzlieferung = this.holzmehlbestand;
				this.holzmehlbestand = 0;
			}
		} finally {
			lock.unlock();
		}
		return holzlieferung;
	}
	
	public synchronized boolean isLagerLeer() {
		return this.holzmehlbestand == 0;
	}
	
	public void produceHolzmehl() {
		System.out.println("Produziert Holzmehl");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ie) {
			// NoDo
		}
		
		synchronized (this) {
			if (this.holzmehlbestand+10 > MAX_LAGER) {
				this.holzmehlbestand = MAX_LAGER;
			} else {
				this.holzmehlbestand +=10;
			}
			System.out.println("Lagerbestand (t)" + this.holzmehlbestand);
			this.notifyAll();
		}
	}

}
