package be.ccfun.aoc.day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day18 {

	public static void main(String[] args) throws IOException {
//		SFN sfn = SFNUtil.create("[[1,9],[8,5]]");
//		SFN n1 = SFNUtil.create("[1,2]");
//		SFN n2 = SFNUtil.create("[[3,4],5]");
//		SFN result = SFNUtil.add(n1, n2);
//		System.out.println(result);
//
//		SFN toReduce = SFNUtil.create("[[3,[2,[1,[7,3]]]],[6,[5,[4,[3,2]]]]]");
//		System.out.println(toReduce);
//		System.out.println(SFNUtil.reduce(toReduce));
//
//
//		toReduce = SFNUtil.create("[[[[[9,8],1],2],3],4]");
//		System.out.println(SFNUtil.reduce(toReduce));
//		SFN a1 = SFNUtil.create("[[[[4,3],4],4],[7,[[8,4],9]]]");
//		SFN a2 = SFNUtil.create("[1,1]");
//		SFN add = SFNUtil.add(a1, a2);
//		System.out.println(add);
//		SFN reduced = SFNUtil.reduce(add);
//		System.out.println(reduced);
//		System.out.println(reduced.getMagnitude());
//
//
//		System.out.println(SFNUtil.create("[[[[8,7],[7,7]],[[8,6],[7,7]]],[[[0,7],[6,6]],[8,7]]]").getMagnitude());

		//System.out.println(SFNUtil.reduce(SFNUtil.create("[[6,[5,[4,[3,2]]]],1]")));


		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day18.txt"));
		SFN add = SFNUtil.create(lines.get(0));
		for (int i = 1; i < lines.size(); i++) {
			add = SFNUtil.add(add, SFNUtil.create(lines.get(i)));
			add = SFNUtil.reduce(add);
			System.out.println(add);
		}
		System.out.println(add);
		System.out.println(add.getMagnitude());

	}

}
