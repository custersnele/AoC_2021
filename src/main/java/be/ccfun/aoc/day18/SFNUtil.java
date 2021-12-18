package be.ccfun.aoc.day18;

import java.util.Stack;

public class SFNUtil {

	public static SFN add(SFN sfn, SFN other) {
		return reduce(new USFN(sfn, other));
	}

	public static SFN reduce(SFN sfn) {
		SFN next = reduceOne(sfn).split().getResult();
		while (!next.toString().equals(sfn.toString())) {
			sfn = next;
			next = reduceOne(sfn).split().getResult();
		}
		//System.out.println("REDUCED: " + next);
		return next;
	}

	public static SFN reduceOne(SFN sfn) {
		SFN reduce = SFNUtil.reduceOneStep(sfn);
		while (!sfn.toString().equals(reduce.toString())) {
			//System.out.println("REDUCE" + reduce);
			sfn = reduce;
			reduce = SFNUtil.reduceOneStep(sfn);
		}
		return reduce;
	}

	private static SFN reduceOneStep(SFN sfn) {
		Stack<SFN> sfnStack = new Stack<>();
		String text = sfn.toString();
		int depth = -1;
		int nextAdd = 0;
		boolean reduced = false;
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == ']') {
				SFN right = sfnStack.pop();
				SFN left = sfnStack.pop();
				if (depth == 4 && !reduced) {
					reduced = true;
					if (!sfnStack.isEmpty()) {
						SFN pop = sfnStack.pop();
						depth--;
						pop.add(left.getLeft());
						sfnStack.push(pop);
						sfnStack.push(new SFNValue(0));
					} else {
						sfnStack.push(new SFNValue(0));
					}
					nextAdd = ((SFNValue) right).getValue();
				} else {
					sfnStack.push(new USFN(left, right));
				}
				depth--;
			} else if (Character.isDigit(c)) {
				String number = String.valueOf(c);
				int idx = i + 1;
				while (Character.isDigit(text.charAt(idx))) {
					number += String.valueOf(text.charAt(idx));
					idx++;
				}
				i = idx - 1;
				SFNValue sfnValue = new SFNValue(Integer.parseInt(number) + nextAdd);
				sfnStack.push(sfnValue);
				nextAdd = 0;
			} else if (c == '[') {
				depth++;
			}
		}
		while (sfnStack.size() > 1) {
			SFN pop = sfnStack.pop();
			SFN pop1 = sfnStack.pop();
			sfnStack.push(new USFN(pop1, pop));
		}
		return sfnStack.pop();
	}

	public static SFN create(String text) {
		Stack<SFN> sfnStack = new Stack<>();
		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);
			if (c == ']') {
				SFN right = sfnStack.pop();
				SFN left = sfnStack.pop();
				sfnStack.push(new USFN(left, right));
			} else if (Character.isDigit(c)) {
				sfnStack.push(new SFNValue(Integer.parseInt(String.valueOf(c))));
			}
		}
		return sfnStack.pop();
	}

}
