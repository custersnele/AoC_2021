package be.ccfun.aoc.day18;

public class SplitResult {
	private SFN result;
	private boolean splitted;

	public SplitResult(SFN result, boolean splitted) {
		this.result = result;
		this.splitted = splitted;
	}

	public boolean isSplitted() {
		return splitted;
	}

	public SFN getResult() {
		return result;
	}
}
