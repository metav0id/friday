package de.defdesign.friday;

import java.util.ArrayList;
import java.util.List;

public class SomeThreads {
	
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		Thread th = new Thread() {
			@Override
			public void run() {
				for (int i=0; i< 100000; i++) {
					int j = (int)(Math.random()*101);
					list.add(j);
				}
			}
		};
		
		th.start();
		
		try {
			th.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}
		
		for (int i=0; i< 1000000; i++) {
			
		}
		
		System.out.println(list.size());
		
	}

}
