package be.ccfun.aoc.day06;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Day6 {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1,1,1,1,1,5,1,1,1,5,1,1,3,1,5,1,4,1,5,1,2,5,1,1,1,1,3,1,4,5,1,1,2,1,1,1,2,4,3,2,1,1,2,1,5,4,4,1,4,1,1,1,4,1,3,1,1,1,2,1,1,1,1,1,1,1,5,4,4,2,4,5,2,1,5,3,1,3,3,1,1,5,4,1,1,3,5,1,1,1,4,4,2,4,1,1,4,1,1,2,1,1,1,2,1,5,2,5,1,1,1,4,1,2,1,1,1,2,2,1,3,1,4,4,1,1,3,1,4,1,1,1,2,5,5,1,4,1,4,4,1,4,1,2,4,1,1,4,1,3,4,4,1,1,5,3,1,1,5,1,3,4,2,1,3,1,3,1,1,1,1,1,1,1,1,1,4,5,1,1,1,1,3,1,1,5,1,1,4,1,1,3,1,1,5,2,1,4,4,1,4,1,2,1,1,1,1,2,1,4,1,1,2,5,1,4,4,1,1,1,4,1,1,1,5,3,1,4,1,4,1,1,3,5,3,5,5,5,1,5,1,1,1,1,1,1,1,1,2,3,3,3,3,4,2,1,1,4,5,3,1,1,5,5,1,1,2,1,4,1,3,5,1,1,1,5,2,2,1,4,2,1,1,4,1,3,1,1,1,3,1,5,1,5,1,1,4,1,2,1);
		//List<Integer> numbers = Arrays.asList(3,4,3,1,2);
		Map<Integer, Long> nof = new HashMap<>();
		for (int i = 0; i <= 8; i++) {
			nof.put(i, (long) Collections.frequency(numbers, i));
		}
		for (int day = 0; day < 256; day ++) {
			long newFish = nof.get(0);
			for (int i = 0; i < 8; i++) {
				nof.put(i, nof.get(i+1));
			}
			nof.put(8, newFish);
			nof.put(6, nof.get(6) + newFish);
			System.out.println(nof.values().stream().mapToLong(i -> i).sum());
		}
	}

}
