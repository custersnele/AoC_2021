package be.ccfun.aoc.day05;

public class Point implements Comparable<Point> {
	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Point point = (Point) o;

		if (x != point.x) {
			return false;
		}
		return y == point.y;
	}

	@Override
	public int compareTo(Point o) {
		return x - o.x + y - o.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "(" + x +
				", " + y +
				')';
	}
}
