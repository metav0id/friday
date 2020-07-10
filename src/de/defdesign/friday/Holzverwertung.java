package de.defdesign.friday;

public class Holzverwertung {
	public static void main(String[] args) {
		HolzMuehle holzi = new HolzMuehle("McBuche");
		
		holzi.start();
		
		Maschine m1 = new Maschine("Spanplattenpresse", holzi);
		Maschine m2 = new Maschine("Pelletpresse", holzi);
		Maschine m3 = new Maschine("Holzverpackungsdingsbums", holzi);
		
		m1.start();
		m2.start();
		m3.start();
	}

}
