package be.ccfun.aoc.day11;

public class Dumbo {
	private int x;
	private int y;
	private int energy;
	private boolean flashed;
	private int numberOfFlashes;

	public Dumbo(int x, int y, int energy) {
		this.x = x;
		this.y = y;
		this.energy = energy;
	}

	public boolean isFlashing() {
		return energy > 9;
	}

	public boolean isFlashed() {
		return flashed;
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

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getNumberOfFlashes() {
		return numberOfFlashes;
	}

	public void flash() {
		numberOfFlashes++;
		flashed = true;
		energy = 0;
	}

	public void increase() {
		if (!flashed) {
			this.energy++;
		}
	}

	public void setFlashed(boolean flashed) {
		this.flashed = flashed;
	}

	public boolean isNeighbour(Dumbo d) {
		if (d.getX() == x && d.getY() == y - 1) {
			return true;
		} else if (d.getX() == x && d.getY() == y + 1) {
			return true;
		} else if (d.getX() == x - 1) {
			return d.getY() == y - 1 || d.getY() == y || d.getY() == y + 1;
		} else if (d.getX() == x + 1) {
			return d.getY() == y - 1 || d.getY() == y || d.getY() == y + 1;
		}
		return false;
	}
}
