package be.ccfun.aoc.day06;

import java.util.Optional;

public class Lanternfish {
	private int counter;

	public Lanternfish(int counter) {
		this.counter = counter;
	}

	public Lanternfish() {
		this. counter = 8;
	}

	public Optional<Lanternfish> next() {
		if (counter == 0) {
			counter = 6;
			return Optional.of(new Lanternfish());
		}
		counter--;
		return Optional.empty();
	}
}
