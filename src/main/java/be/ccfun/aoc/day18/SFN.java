package be.ccfun.aoc.day18;

public interface SFN {

	long getMagnitude();
	void add(int delta);
	int getLeft();
	boolean canSplit();
	SplitResult split();
}
