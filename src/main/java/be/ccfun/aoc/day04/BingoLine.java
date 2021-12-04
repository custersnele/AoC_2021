package be.ccfun.aoc.day04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.ToIntFunction;

public class BingoLine<T> {
	private final List<T> orderedItems;
	private final Map<T, Boolean> items = new HashMap<>();

	public BingoLine(List<T> items) {
		orderedItems = items;
		items.forEach(item -> this.items.put(item, false));
	}

	public void draw(T item) {
		if (items.containsKey(item)) {
			if ((Integer) item == 96) {
				System.out.println(items);
			}
			items.put(item, true);
		}
	}

	public boolean complete() {
		return items.values().stream().allMatch(v -> v);
	}

	public int score(ToIntFunction<T> f) {
		return items.entrySet().stream().filter(e -> !e.getValue())
				.mapToInt(e -> f.applyAsInt(e.getKey()))
				.sum();
	}

	public T getItem(int idx) {
		return orderedItems.get(idx);
	}
}
