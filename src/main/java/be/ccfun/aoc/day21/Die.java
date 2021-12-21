package be.ccfun.aoc.day21;

import java.util.Arrays;

public class Die {
	private int current = 1;
	private long used;

	public int next() {
		int next = 0;
		int[] values = new int[3];
		for (int i = 0; i < 3; i++) {
			values[i] = current;
			next += current;
			add();
		}
		System.out.println(Arrays.toString(values));
		used++;
		return next;
	}

	private void add() {
		current++;
		if (current == 101) {
			current = 1;
		}
	}

	public long getUsed() {
		return used;
	}
}
