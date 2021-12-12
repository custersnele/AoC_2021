package be.ccfun.aoc.day12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://www.geeksforgeeks.org/find-paths-given-source-destination/
public class Graph {

	private Map<String, List<String>> adjacent = new HashMap<>();

	void addEdge(String from, String to) {
		if (!adjacent.containsKey(from)) {
			adjacent.put(from, new ArrayList<>());
		}
		adjacent.get(from).add(to);
	}

	public void createAllPaths(String start, String end) {
		List<String> visited = new ArrayList<>();
		ArrayList<String> pathList = new ArrayList<>();
		pathList.add(start);
		int total = printAllPathsUtil(start, end, visited, pathList);
		System.out.println(total);
	}

	private int printAllPathsUtil(String start, String end,
	                               List<String> visited,
	                               List<String> localPathList) {

		if (start.equals(end)) {
			System.out.println(localPathList);
			// if match found then no need to traverse more till depth
			return 1;
		}

		// Mark the current node (only small caves)
		if (start.toLowerCase().equals(start)) {
			visited.add(start);
		}

		// Recur for all the vertices
		// adjacent to current vertex
		int sum = 0;
		if (adjacent.get(start) != null) {
			for (String next : adjacent.get(start)) {
				if (allowedToVisited(visited, next)) {
					List<String> newLocalPathList = new ArrayList<>(localPathList);
					newLocalPathList.add(next);
					sum += printAllPathsUtil(next, end, new ArrayList<>(visited), newLocalPathList);
				}
			}
		}
		return sum;
	}

	private boolean allowedToVisited(List<String> visited, String next) {
		if (!visited.contains(next)) {
			return true;
		}
		if (next.equals("start") || next.equals("end")) {
			return false;
		}
		return visited.stream().distinct().mapToLong(s -> visited.stream().filter(v -> v.equals(s)).count()).noneMatch(l -> l == 2);
	}
}
