package be.ccfun.aoc.day03;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Day3P2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day3.txt"));
		int ogr = ogr(new ArrayList<>(lines));
		int csr = csr(new ArrayList<>(lines));
		System.out.println(ogr);
		System.out.println(csr);
		System.out.println(ogr * csr);
	}

	private static int ogr(List<String> lines) {
		for (int i = 0; lines.size() > 1 && i < lines.get(0).length(); i++) {
			int finalI = i;
			long countZero = lines.stream().map(line -> line.substring(finalI, finalI + 1)).filter(s -> s.equals("0")).count();
			long countOne = lines.size() - countZero;
			if (countOne >= countZero) {
				lines = lines.stream().filter(line -> line.charAt(finalI) == '1').collect(Collectors.toList());
			} else {
				lines = lines.stream().filter(line -> line.charAt(finalI) == '0').collect(Collectors.toList());
			}
		}
		return Integer.parseInt(lines.get(0), 2);
	}

	private static int csr(List<String> lines) {
		for (int i = 0; lines.size() > 1 && i < lines.get(0).length(); i++) {
			int finalI = i;
			long countZero = lines.stream().map(line -> line.substring(finalI, finalI + 1)).filter(s -> s.equals("0")).count();
			long countOne = lines.size() - countZero;
			if (countOne >= countZero) {
				lines = lines.stream().filter(line -> line.charAt(finalI) == '0').collect(Collectors.toList());
			} else {
				lines = lines.stream().filter(line -> line.charAt(finalI) == '1').collect(Collectors.toList());
			}
		}
		return Integer.parseInt(lines.get(0), 2);
	}
}
