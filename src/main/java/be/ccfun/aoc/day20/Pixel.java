package be.ccfun.aoc.day20;

public class Pixel {
	private int x;
	private int y;
	private boolean light;

	public Pixel(int x, int y, char karakter) {
		this.x = x;
		this.y = y;
		this.light = karakter == '#';
	}

	public boolean isLight() {
		return light;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		Pixel pixel = (Pixel) o;

		if (x != pixel.x) {
			return false;
		}
		return y == pixel.y;
	}

	@Override
	public int hashCode() {
		int result = x;
		result = 31 * result + y;
		return result;
	}

	public boolean atPosition(int x, int y) {
		return this.x == x && this.y == y;
	}

	public char getCharacter() {
		return light? '1' : '0';
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

	public boolean between(int minX, int maxX, int minY, int maxY) {
		return x > minX && x < maxX && y > minY && y < maxY;
	}

}
