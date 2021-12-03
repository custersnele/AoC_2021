package be.ccfun.aoc.day02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day2 {

	public static void main(String[] args) throws IOException {
		long x = 0;
		long depth = 0;
		long aim = 0;
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day2.txt"));
		for (String line : lines) {
			String[] split = line.split(" ");
			final int value = Integer.parseInt(split[1]);
			switch (split[0]) {
				case "forward" -> { x += value; depth += aim * value; }
				case "down" -> { aim += value; }
				case "up" ->  { aim -= value; }
			}
			System.out.println(x + " " + depth +  " " + aim);
		}
		System.out.println(x);
		System.out.println(depth);
		System.out.println(x * depth);
	}


}
