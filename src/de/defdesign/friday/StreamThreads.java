package de.defdesign.friday;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

public class StreamThreads {
	
	public static void main(String[] args) {
		List<Double> doubleList = new ArrayList<>();
		for (int i=0; i<5000; i++) {
			doubleList.add(((Integer)i).doubleValue());
		}
		
		OptionalDouble average = doubleList.stream().parallel().mapToDouble(a -> a).average();
		
		if (average.isPresent()) {
			System.out.println(average.getAsDouble());
		}
	}

}
