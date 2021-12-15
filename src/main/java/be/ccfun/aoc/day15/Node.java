package be.ccfun.aoc.day15;

public class Node implements Comparable<Node> {
	private Point point;
	private long distance;

	public Node(Point point, long distance) {
		this.point = point;
		this.distance = distance;
	}

	@Override
	public int compareTo(Node o) {
		return Long.compare(distance, o.distance);
	}

	public Point getPoint() {
		return point;
	}

	public long getDistance() {
		return distance;
	}
}
