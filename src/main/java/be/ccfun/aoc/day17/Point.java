package be.ccfun.aoc.day17;

import java.util.ArrayList;
import java.util.List;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
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

	public void addVelocity(Point velocity) {
		x += velocity.x;
		y += velocity.y;
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

	public boolean inTarget(int targetXmin, int targetXmax, int targetYmin, int targetYMax) {
		return x >= targetXmin && x <= targetXmax && y <= targetYmin && y >= targetYMax;
	}

	public List<Point> neighbours(int maxX, int maxY) {
		List<Point> result = new ArrayList<>();
		if (x - 1 >= 0) {
			result.add(new Point(x - 1, y));
		}
		if (x + 1 <= maxX) {
			result.add(new Point(x + 1, y));
		}
		if (y - 1 >= 0) {
			result.add(new Point(x, y - 1));
		}
		if (y + 1 <= maxY) {
			result.add(new Point(x, y + 1));
		}
		return result;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	@Override
	public String toString() {
		return "Point{" +
				"x=" + x +
				", y=" + y +
				'}';
	}
}
