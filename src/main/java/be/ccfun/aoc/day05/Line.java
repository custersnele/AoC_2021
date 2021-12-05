package be.ccfun.aoc.day05;

import java.util.ArrayList;
import java.util.List;

public class Line {
	private Point start;
	private Point end;

	public Line(int x1, int y1, int x2, int y2) {
		this.start = new Point(x1, y1);
		this.end = new Point(x2, y2);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Line line = (Line) o;

		if (start != null ? !start.equals(line.start) : line.start != null) {
			return false;
		}
		return end != null ? end.equals(line.end) : line.end == null;
	}

	@Override
	public int hashCode() {
		int result = start != null ? start.hashCode() : 0;
		result = 31 * result + (end != null ? end.hashCode() : 0);
		return result;
	}

	public Line(Point start, Point end) {
		this.start = start;
		this.end = end;
	}

	public List<Point> allPoints() {

		List<Point> all = new ArrayList<>();
		if (start.getX() == end.getX() || start.getY() == end.getY()) {
			for (int x = Math.min(start.getX(), end.getX()); x <= Math.max(start.getX(), end.getX()); x++) {
				for (int y = Math.min(start.getY(), end.getY()); y <= Math.max(start.getY(), end.getY()); y++) {
					all.add(new Point(x, y));
				}
			}
		} else {
			int x = start.getX();
			int addx = start.getX() < end.getX()? +1 : -1;
			int y = start.getY();
			int addy = start.getY() < end.getY()? +1 : -1;
			while (x != end.getX() && y != end.getY()) {
				all.add(new Point(x, y));
				x += addx;
				y += addy;
			}
			all.add(new Point(end.getX(), end.getY()));
		}
		return all;
	}
}
