package be.ccfun.aoc.day18;

public class USFN implements SFN{
	private SFN left;
	private SFN right;

	public USFN(SFN left, SFN right) {
		this.left = left;
		this.right = right;
	}

	@Override
	public int getLeft() {
		return left.getLeft();
	}

	public boolean canSplit() {
		return left.canSplit() || right.canSplit();
	}

	public SplitResult split() {
		SplitResult resultLeft = left.split();
		if (!resultLeft.isSplitted()) {
			SplitResult resultRight = right.split();
			return new SplitResult(new USFN(resultLeft.getResult(), resultRight.getResult()), resultRight.isSplitted());
		} else {
			return new SplitResult(new USFN(resultLeft.getResult(), right), true);
		}
	}

	public long getMagnitude() {
		return left.getMagnitude() * 3 + right.getMagnitude() * 2;
	}

	public void add(int delta) {
		right.add(delta);
	}

	@Override
	public String toString() {
		return "[" + left + "," + right + "]";
	}
}
