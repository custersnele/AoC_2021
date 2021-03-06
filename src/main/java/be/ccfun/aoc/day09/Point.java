package be.ccfun.aoc.day09;

public class Point {
	private int x;
	private int y;
	private int height;

	public Point(int x, int y, int height) {
		this.x = x;
		this.y = y;
		this.height = height;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	public int getRisk() {
		return height + 1;
	}


}
