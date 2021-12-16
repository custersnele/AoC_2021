package be.ccfun.aoc.day16;

import java.util.ArrayList;
import java.util.List;

public class PacketResult {
	private int version;
	private int type;
	private long literal;
	private int length;
	private List<PacketResult> children = new ArrayList<>();

	public PacketResult(int version, int type) {
		this.version = version;
		this.type = type;
	}

	public int getVersion() {
		return version;
	}

	public int getType() {
		return type;
	}

	public long getLiteral() {
		return literal;
	}

	public void addChild(PacketResult child) {
		children.add(child);
	}

	public void setLiteral(long literal) {
		this.literal = literal;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public List<PacketResult> getChildren() {
		return children;
	}

	public long getResult() {
		switch (type) {
			case 0 -> {
				return getChildren().stream().mapToLong(c -> c.getResult()).sum();
			}
			case 1 -> {
				return getChildren().stream().mapToLong(c -> c.getResult()).reduce(1, (n, acc) -> n * acc);
			}
			case 2 -> {
				return getChildren().stream().mapToLong(c -> c.getResult()).min().getAsLong();
			}
			case 3 -> {
				return getChildren().stream().mapToLong(c -> c.getResult()).max().getAsLong();
			}
			case 4 -> {
				return getLiteral();
			}
			case 5 -> {
				if (getChildren().get(0).getResult() > getChildren().get(1).getResult()) {
					return 1;
				} else {
					return 0;
				}
			}
			case 6 -> {
				if (getChildren().get(0).getResult() < getChildren().get(1).getResult()) {
					return 1;
				} else {
					return 0;
				}
			}
			case 7 -> {
				if (getChildren().get(0).getResult() == getChildren().get(1).getResult()) {
					return 1;
				} else {
					return 0;
				}
			}
			default -> {
				return 0;
			}
		}
	}


}
