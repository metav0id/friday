package de.defdesign.friday;

public class Maschine extends Thread {
	
	private String name;
	private HolzMuehle holzmuehle;
	
	public Maschine(String name, HolzMuehle holzmuehle) {
		this.name = name;
		this.holzmuehle = holzmuehle;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				anfordern();
			} catch (InterruptedException ie) {
				// NoDo
			}
		}
	}
	
	private void anfordern() throws InterruptedException {
		
		if (holzmuehle.isLagerLeer()) {
			synchronized (holzmuehle) {				
					this.holzmuehle.wait();				
			}
		} else {
			int holzbedarf = (int)(Math.random()*4)+3;
			int holzlieferung = holzmuehle.ausliefern(holzbedarf);
			System.out.println(name + " fordert " + holzlieferung + "t holzmehl an.");
		}
	}
	 

}
