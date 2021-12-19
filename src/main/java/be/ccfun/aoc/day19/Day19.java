package be.ccfun.aoc.day19;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Day19 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/example/day19.txt"));
		List<AoCScanner> scanners = new ArrayList<>();
		int count = 0;
		AoCScanner scanner = null;
		for (String line : lines) {
			if (line.startsWith("---")) {
				if (scanner != null) {
					scanners.add(scanner);
				}
				scanner = new AoCScanner(count++);
			} else if (!line.isEmpty()) {
				String[] split = line.split(",");
				scanner.addBeacon(new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]), Integer.parseInt(split[2])));
			}
		}
		scanners.add(scanner);
		List<List<Point>> coordinates = new ArrayList<>();
		for (int i = 0; i < scanners.size(); i++) {
			for (int j = i + 1; j < scanners.size(); j++) {
				System.out.println("Scanner " + i + " = " + j);
				AoCScanner s1 = scanners.get(i);
				AoCScanner s2 = scanners.get(j);
				List<List<Point>> result = s1.commonBeacons(s2);
				merge(coordinates, result);
			}
		}
		int beacons = coordinates.size();
		System.out.println(beacons);
		for (List<Point> beacon : coordinates) {
			System.out.println(beacon);
		}
		for (AoCScanner sc : scanners) {
			for (Point p : sc.getBeacons()) {
				boolean existing = false;
				for (List<Point> beacon : coordinates) {
					if (beacon.contains(p)) {
						existing = true;
					}
				}
				if (!existing) {
					beacons++;
				}
			}
		}
		System.out.println(beacons);
	}


	public static void merge(List<List<Point>> seen, List<List<Point>> newBeacons) {
		for (List<Point> beacon : newBeacons) {
			boolean added = false;
			for (List<Point> seenBean : seen) {
				if (sharePoint(beacon, seenBean)) {
					seenBean.addAll(beacon);
					added = true;
				}
			}
			if (!added) {
				seen.add(beacon);
			}
		}
	}


	public static boolean sharePoint(List<Point> list, List<Point> otherList) {
		for (Point p : list) {
			for (Point p2 : otherList) {
				if (p.equals(p2)) {
					return true;
				}
			}
		}
		return false;
	}



}
