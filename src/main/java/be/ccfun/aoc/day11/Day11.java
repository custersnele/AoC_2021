package be.ccfun.aoc.day11;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class Day11 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day11.txt"));
		List<Dumbo> dumbos = new ArrayList<>();
		int maxY = lines.size();
		int maxX = lines.get(0).length();
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				dumbos.add(new Dumbo(x, y, Integer.parseInt(lines.get(y).substring(x, x+1))));
			}
		}
		print(dumbos, maxX, maxY);

		for (int i = 0; i < 1000; i++) {
			dumbos.forEach(d -> d.increase());
			long flashing = dumbos.stream().filter(d -> d.isFlashing()).count();
			while (flashing > 0) {
				List<Dumbo> flashers = dumbos.stream().filter(d -> d.getEnergy() > 9).collect(Collectors.toList());
				for (Dumbo flasher : flashers) {
					flasher.flash();
					dumbos.stream().filter(d -> d.isNeighbour(flasher)).forEach(d -> d.increase());
				}
				flashers.forEach(f -> f.setEnergy(0));
				flashing = dumbos.stream().filter(d -> d.isFlashing()).count();
			}
			long count = dumbos.stream().filter(d -> !d.isFlashed()).count();
			if (count == 0) {
				System.out.println("STEP: " + (i+1));
			}
			dumbos.forEach(d -> d.setFlashed(false));
			//print(dumbos, maxX, maxY);
		}
		System.out.println(dumbos.stream().mapToLong(d -> d.getNumberOfFlashes()).sum());
	}

	public static void print(List<Dumbo> dumbos, int maxX, int maxY) {
		for (int y = 0; y < maxY; y++) {
			for (int x = 0; x < maxX; x++) {
				int finalX = x;
				int finalY = y;
				Dumbo dumbo = dumbos.stream().filter(d -> d.getX() == finalX && d.getY() == finalY).findAny().get();
				System.out.print(dumbo.getEnergy());
			}
			System.out.println();
		}
		System.out.println();
	}

}
