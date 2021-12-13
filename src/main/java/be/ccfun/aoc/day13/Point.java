package be.ccfun.aoc.day13;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
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

	public void foldX(int x) {
		if (this.x >= x) {
			this.x = x - Math.abs(x - this.x);
		}
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

	public void foldY(int y) {
		if (this.y >= y) {
			this.y = y - Math.abs(y - this.y);
		}
	}
}
