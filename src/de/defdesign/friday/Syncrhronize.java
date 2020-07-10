package de.defdesign.friday;

class Printer extends Thread {
	private char zeichen;
	private int anzahl;
	private int zeilen;
	final Object newObject = new Object();
	
	public Printer (char zeichen, int anzahl, int zeilen) {
		this.zeichen = zeichen;
		this.anzahl = anzahl;
		this.zeilen = zeilen;
	}
	
	@Override
	public void run() {
		Object monitor = Printer.class;
		synchronized (monitor) {
		for (int j = 0; j< this.zeilen; j++) {
			
				for (int i=0; i< this.anzahl; i++) {
					System.out.print(this.zeichen);
				}
				System.out.println();
			}
		}
	}
	
}

public class Syncrhronize {
	public static void main(String[] args) {
		Printer p1 = new Printer('a', 10, 200);
		p1.start();
		Printer p2 = new Printer('*', 5, 400);
		p2.start();
		
		try {
			p1.join();
			p2.join();
		} catch (Exception e) {
			
		}
	}

}
