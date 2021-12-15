package be.ccfun.aoc.day15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Day15Dijkstra {
	private static List<String> lines = null;

	public static long dijkstra(Point src, Point destination, int maxX, int maxY) {
		Set<Point> visited = new HashSet<>();
		PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
		priorityQueue.add(new Node(src, 0));

		while (!visited.contains(destination)) {
			Node next = priorityQueue.remove();

			for (Point point : next.getPoint().neighbours(maxX, maxY)) {
				if (!visited.contains(point)) {
					int cost = getCost(point);
					priorityQueue.add(new Node(point, next.getDistance() + cost));
					if (point.equals(destination)) {
						return next.getDistance() + cost;
					}
					visited.add(point);
				}
			}
		}
		return 0;
	}

	private static int getCost(Point point) {
		int subX = lines.get(0).length();
		int subY = lines.size();
		int x = point.getX() % subX;
		int y = point.getY() % subY;
		int extraX = point.getX() / subX;
		int extraY = point.getY() / subY;
		int value = Integer.parseInt(lines.get(y).substring(x, x+1)) + extraX + extraY;
		if (value > 9) {
			value = (value % 10) + 1;
		}
		return value;
	}

	public static void main(String[] arg) throws IOException {
		lines = Files.readAllLines(Path.of("src/main/resources/day15.txt"));
		int tiles = 5;
		int destX = lines.get(0).length() * tiles - 1;
		int destY = lines.size() * tiles - 1;
		int curX = 0;
		int curY = 0;

		for (int y = 0; y <= destY; y++) {
			for (int x = 0; x <= destX; x++) {
				System.out.print(getCost(new Point(x, y)));
			}
			System.out.println();
		}

		long result = dijkstra(new Point(curX, curY), new Point(destX, destY), destX, destY);
		System.out.println(result);

	}
}
