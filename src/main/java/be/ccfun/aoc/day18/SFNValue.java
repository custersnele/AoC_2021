package be.ccfun.aoc.day18;

public class SFNValue implements SFN{
	private int value;

	public SFNValue(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void add(int delta) {
		value += delta;
	}

	public boolean canSplit() {
		return value > 9;
	}

	public SplitResult split() {
		if (value > 9) {
			int half = value / 2;
			return new SplitResult(new USFN(new SFNValue(half), new SFNValue(value - half)), true);
		} else {
			return new SplitResult(new SFNValue(value), false);
		}
	}

	@Override
	public long getMagnitude() {
		return value;
	}

	@Override
	public int getLeft() {
		return value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
