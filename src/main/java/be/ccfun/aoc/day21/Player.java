package be.ccfun.aoc.day21;

public class Player {
	private int position = -1;
	private long score;
	private int[] positions = {1,2,3,4,5,6,7,8,9,10};

	public Player(int position) {
		this.position = position - 1;
	}

	public void move(int steps) {
		position = (position + steps) % 10;
		score += positions[position];
	}


	public int getPosition() {
		return positions[position];
	}

	public long getScore() {
		return score;
	}

	public boolean won() {
		return score >= 1000;
	}
}
