package de.defdesign.friday;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorIntro {
	public static void main(String[] args) {
		int maxThreads = Runtime.getRuntime().availableProcessors();
		ExecutorService service = Executors.newFixedThreadPool(maxThreads);
		
		for (int i = 0; i <100; i++) {
			Runnable task = () -> {
				Double r = Math.random()*1000000;
				System.out.println("Task in " + Thread.currentThread().getId());
			};
			service.execute(task);
		}
		
		service.shutdown();
	}

}
