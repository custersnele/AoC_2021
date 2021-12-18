package be.ccfun.aoc.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day18 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day18.txt"));
		SFN add = SFNUtil.create(lines.get(0));
		for (int i = 1; i < lines.size(); i++) {
			add = SFNUtil.add(add, SFNUtil.create(lines.get(i)));
			System.out.println(add);
		}
		System.out.println(add);
		System.out.println(add.getMagnitude());

		long largest = 0;
		for (int i = 0; i < lines.size(); i++) {
			for (int j = 0; j < lines.size(); j++) {
				if (i != j) {
					SFN sum = SFNUtil.add(SFNUtil.create(lines.get(i)), SFNUtil.create(lines.get(j)));
					if (sum.getMagnitude() > largest) {
						largest = sum.getMagnitude();
					}
				}
			}
		}
		System.out.println(largest);

	}

}
