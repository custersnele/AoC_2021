package be.ccfun.aoc.day04;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day4 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day4.txt"));
		List<Integer> numbers = Arrays.stream(lines.get(0).split(","))
				.map(Integer::parseInt)
				.collect(Collectors.toList());
		List<Board<Integer>> boards = new ArrayList<>();
		Board<Integer> nextBoard = new Board<>();
		for (int i = 2; i < lines.size(); i++) {
			System.out.println(lines.get(i));
			if (lines.get(i).isEmpty()) {
				boards.add(nextBoard);
				nextBoard.createHorizontalLines();
				nextBoard = new Board<>();
			} else {
				nextBoard.addLine(new BingoLine<>(Arrays.stream(lines.get(i).trim().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList())));
			}
		}
		boards.add(nextBoard);
		for (int number : numbers) {
			boards.forEach(b -> b.draw(number));
			List<Board<Integer>> winningBoards = boards.stream().filter(Board::winner).collect(Collectors.toList());
			for (Board<Integer> board : winningBoards) {
				int score = board.score();
				System.out.println("SCORE");
				System.out.println(score);
				System.out.println(number);
				System.out.println(number * score);
			}
			boards.removeAll(winningBoards);

		}


	}

}
