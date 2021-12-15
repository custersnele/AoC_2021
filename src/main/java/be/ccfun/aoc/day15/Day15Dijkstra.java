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
					int cost = Integer.parseInt(lines.get(point.getY()).substring(point.getX(), point.getX()+1));
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

	public static void main(String[] arg) throws IOException {
		lines = Files.readAllLines(Path.of("src/main/resources/day15.txt"));
		int destX = lines.get(0).length() - 1;
		int destY = lines.size() - 1;
		int curX = 0;
		int curY = 0;

		long result = dijkstra(new Point(curX, curY), new Point(destX, destY), destX, destY);
		System.out.println(result);

	}
}
