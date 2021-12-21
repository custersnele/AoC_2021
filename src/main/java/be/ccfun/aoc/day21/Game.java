package be.ccfun.aoc.day21;

public class Game {

	public static void main(String[] args) {
		Player[] players = new Player[2];
		players[0] = new Player(8);
		players[1] = new Player(3);
		Die die = new Die();
		int current = 0;
		while (!players[0].won() && !players[1].won()) {
			int next = die.next();
			players[current].move(next);
			System.out.println("Player " + 1 + " rolls " + next + " and moves to space " + players[current].getPosition() + "for a total score of " + players[current].getScore() +".");
			current = (current + 1) % 2;
		}
		long used = die.getUsed();
		System.out.println(used);
		if (players[0].won()) {
			long score = players[1].getScore();
			System.out.println(score);
			System.out.println(3 * used * score);
		} else {
			long score = players[0].getScore();
			System.out.println(score);
			System.out.println(3 * used * score);
		}
		System.out.println();

	}

}
