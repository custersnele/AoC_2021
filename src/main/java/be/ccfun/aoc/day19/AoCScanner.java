package be.ccfun.aoc.day19;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AoCScanner {
	private int number;
	private List<Point> beacons = new ArrayList<>();

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		AoCScanner that = (AoCScanner) o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}

	public AoCScanner(int number) {
		this.number = number;
	}

	public void addBeacon(Point point) {
		beacons.add(point);
	}

	public List<Point> fromView(int[] order) {
		return beacons.stream().map(b -> b.createView(order)).collect(Collectors.toList());
	}

	public List<Point> getBeacons() {
		return beacons;
	}

	public int getNumber() {
		return number;
	}

	public List<List<Point>> commonBeacons(AoCScanner otherBeacon) {
		int commonBeacons = 0;
		List<List<Point>> beaconsAOC = new ArrayList<>();
		for (int dx = -3; dx <=3 ; dx++) {
			for (int dy = -3; dy <= 3; dy++) {
				for (int dz = -3; dz <= 3; dz++) {
					if (Math.abs(dx) != Math.abs(dy) && Math.abs(dy) != Math.abs(dz) && Math.abs(dz) != Math.abs(dx) && dx != 0 && dy != 0 && dz != 0) {
						int[] order = {dx, dy, dz};
						if (dx == 1 && dy == 2 && dz == 3) {
						//	System.out.println("DEBUG");
						}
						//System.out.println("ORDER" + Arrays.toString(order));
						Map<Point, Integer> pointCount = new HashMap<>();
						Map<Point, List<List<Point>>> bcoordinate = new HashMap<>();
						//List<Point> points = otherBeacon.fromView(order);
						for (Point point : beacons) {
						//	System.out.println("NEXT POINT");
							for (Point otherPoint : otherBeacon.beacons) {
								Point diff = point.diff2(otherPoint.createView(order)); // in other view
								pointCount.merge(diff, 1, Integer::sum);
								if (!bcoordinate.containsKey(diff)) {
									bcoordinate.put(diff, new ArrayList<>());
								}
								List<Point> combi = new ArrayList<>();
								combi.add(point);
								combi.add(otherPoint);
								bcoordinate.get(diff).add(combi);
						//		System.out.println(diff);
							}
						}
						Point point = Collections.max(pointCount.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
						if (pointCount.get(point) > 2) {
							if (commonBeacons < pointCount.get(point)) {
								commonBeacons = pointCount.get(point);
								beaconsAOC = bcoordinate.get(point);
							}
							System.out.println("SUGGESTION: " + point);
							System.out.println("Beacons: " + beaconsAOC);
						}
					}
				}
			}
		}
		return beaconsAOC;
	}

}
