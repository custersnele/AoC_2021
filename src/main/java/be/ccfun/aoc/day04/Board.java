package be.ccfun.aoc.day04;

import java.util.ArrayList;
import java.util.List;

public class Board<T> {
	private final List<BingoLine<T>> lines = new ArrayList<>();
	private final List<BingoLine<T>> verticalLines = new ArrayList<>();

	public void addLine(BingoLine<T> line) {
		lines.add(line);
	}

	public void createHorizontalLines() {
		for (int i = 0; i < lines.size(); i++) {
			List<T> items = new ArrayList<>();
			for (BingoLine<T> line : lines) {
				items.add(line.getItem(i));
			}
			verticalLines.add(new BingoLine<>(items));
		}
	}

	public void draw(T item) {
		lines.forEach(l -> l.draw(item));
		verticalLines.forEach(l -> l.draw(item));
	}

	public int score() {
		return lines.stream().mapToInt(l -> l.score(f -> (int) f)).sum();
	}

	public boolean winner() {
		List<BingoLine<T>> allLines = new ArrayList<>(lines);
		allLines.addAll(verticalLines);
		return allLines.stream().anyMatch(BingoLine::complete);
	}
}
