package be.ccfun.aoc.day19;

public class Point {

	private int x;
	private int y;
	private int z;

	public Point(int x, int y, int z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Point(int ... v) {
		this.x = v[0];
		this.y = v[1];
		this.z = v[2];
	}

	public Point(Point p) {
		this.x = p.x;
		this.y = p.y;
		this.z = p.z;
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

	public int getZ() {
		return z;
	}

	public int sum() {
		return Math.abs(x) + Math.abs(y) + Math.abs(z);
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
		if (y != point.y) {
			return false;
		}
		return z == point.z;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		result = 31 * result + z;
		return result;
	}

	@Override
	public String toString() {
		return "(" + x +
				"," + y +
				"," + z +
				')';
	}

	public Point diff(Point p) {
		int[] result = new int[3];
		result[0] = Math.abs(x - p.x);
		result[1] = Math.abs(y - p.y);
		result[2] = Math.abs(z - p.z);
		return new Point(result);
	}

	public Point diff2(Point p) {
		int[] result = new int[3];
		result[0] = x - p.x;
		result[1] = y - p.y;
		result[2] = z - p.z;
		return new Point(result);
	}


	public Point createView(int[] order) {
		int[] c = { x, y, z };
		int o0 = Math.abs(order[0]) - 1;
		int o1 = Math.abs(order[1]) - 1;
		int o2 = Math.abs(order[2]) - 1;
		return new Point(order[0] > 0 ? c[o0] : -1 * c[o0],
				order[1] > 0 ? c[o1] : -1 * c[o1],
				order[2] > 0 ? c[o2] : -1 * c[o2]);
	}


}
