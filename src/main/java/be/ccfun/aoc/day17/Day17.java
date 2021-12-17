package be.ccfun.aoc.day17;

public class Day17 {

	public static void main(String[] args) {
		// target area: x=119..176, y=-141..-84
		// target area: x=20..30, y=-10..-5
		int maxHeight = 0;
		int inTargetCount = 0;
		for (int x = 0; x < 500; x++) {
			for (int y = -500; y < 500; y++) {
				Point velocity = new Point(x, y);
				//int height = findMaxHeight(velocity, 119,176,-84, -141);
				//int height = findMaxHeight(velocity, 119,176,-84, -141);
				if (inTarget(velocity, 119,176,-84, -141)) {
				//if (inTarget(velocity, 20,30,-5, -10)) {
					inTargetCount++;
				}
			}
		}
		System.out.println(inTargetCount);
	}

	public static int findMaxHeight(Point velocity, int targetXmin, int targetXmax, int targetYmin, int targetYMax) {
		Point p = new Point(0,0);
		int heighest = p.getY();
		while (!p.inTarget(targetXmin, targetXmax, targetYmin, targetYMax) && p.getX() < targetXmax && p.getY() > targetYMax) {
			p.addVelocity(velocity);
			if (p.getY() > heighest) {
				heighest = p.getY();
			}
			updateVelocity(velocity);
		}
		if (p.inTarget(targetXmin, targetXmax, targetYmin, targetYMax)) {
			return heighest;
		}
		return 0;
	}

	public static boolean inTarget(Point velocity, int targetXmin, int targetXmax, int targetYmin, int targetYMax) {
		Point p = new Point(0,0);
		int heighest = p.getY();
		while (!p.inTarget(targetXmin, targetXmax, targetYmin, targetYMax) && p.getX() < targetXmax && p.getY() > targetYMax) {
			p.addVelocity(velocity);
			if (p.getY() > heighest) {
				heighest = p.getY();
			}
			updateVelocity(velocity);
		}
		return p.inTarget(targetXmin, targetXmax, targetYmin, targetYMax);
	}

	public static void updateVelocity(Point velocity) {
		if (velocity.getX() > 0) {
			velocity.setX(velocity.getX() - 1);
		} else if (velocity.getX() < 0) {
			velocity.setX(velocity.getX() + 1);
		}
		velocity.setY(velocity.getY() - 1);
	}
}
