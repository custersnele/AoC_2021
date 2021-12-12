package be.ccfun.aoc.day12;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day12 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day12.txt"));
			Graph g = new Graph();
			for (String line : lines) {
				String[] split = line.split("-");
				g.addEdge(split[0], split[1]);
				g.addEdge(split[1], split[0]);
			}
			g.createAllPaths("start", "end");
		}

}
