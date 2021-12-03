package be.ccfun.aoc.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day3 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day3.txt"));
		int examples = lines.size();
		String gammaRate = "";
		String epsilonRate = "";
		for (int i =0; i < lines.get(0).length(); i++) {
			int finalI = i;
			long countZero = lines.stream().map(line -> line.substring(finalI, finalI + 1)).filter(s -> s.equals("0")).count();
			long countOne = examples - countZero;
			if (countOne > countZero) {
				gammaRate += "1";
				epsilonRate += "0";
			} else {
				gammaRate += "0";
				epsilonRate += "1";
			}
		}
		final int gRate = Integer.parseInt(gammaRate, 2);
		System.out.println(gRate);
		final int eRate = Integer.parseInt(epsilonRate, 2);
		System.out.println(eRate);
		System.out.println(gRate * eRate);
	}

}
