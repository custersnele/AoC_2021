package be.ccfun.aoc.day20;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Day20V2 {

	public static void main(String[] args) throws IOException {
		List<String> lines = Files.readAllLines(Path.of("src/main/resources/day20.txt"));
		String enhancement = lines.get(0);
		List<Pixel> image = new ArrayList<>();

		for (int l = 2; l < lines.size(); l++) {
			for (int x = 0; x < lines.get(2).length(); x++) {
				image.add(new Pixel(x, l - 2, lines.get(l).charAt(x)));
			}
		}

		int minX = image.stream().mapToInt(p -> p.getX()).min().getAsInt();
		int maxX = image.stream().mapToInt(p -> p.getX()).max().getAsInt();
		int minY = image.stream().mapToInt(p -> p.getY()).min().getAsInt();
		int maxY = image.stream().mapToInt(p -> p.getY()).max().getAsInt();
	//	print(image);

		for (int step = 0; step < 50; step++) {
			System.out.println("STEP:" + step);
			List<Pixel> nextImage = new ArrayList<>();
			minX -= 2;
			maxX += 2;
			minY -= 2;
			maxY += 2;
			for (int y = minY; y <= maxY; y++) {
				for (int x = minX; x <= maxX; x++) {
					int idx = getIndex(image, x, y, step);
					nextImage.add(new Pixel(x, y, enhancement.charAt(idx)));
				}
			}
//			int finalMinX = minX;
//			int finalMaxX = maxX;
//			int finalMinY = minY;
//			int finalMaxY = maxY;
//			image = nextImage.stream().filter(p -> p.between(finalMinX +1, finalMaxX - 1, finalMinY + 1, finalMaxY - 1)).collect(Collectors.toList());
//			minX++;
//			minY++;
//			maxX--;
//			maxY--;
			image = nextImage;
			//print(image);
		}
		//long count = image.stream().filter(p -> p.between(minX+4, maxX-4, minY+4, maxY-4)).filter(p -> p.isLight()).count();
		long count = image.stream().filter(p -> p.isLight()).count();
		//print(image);
		System.out.println(count);
	}


	public static void print(List<Pixel> image) {
		int minX = image.stream().mapToInt(p -> p.getX()).min().getAsInt();
		int maxX = image.stream().mapToInt(p -> p.getX()).max().getAsInt();
		int minY = image.stream().mapToInt(p -> p.getY()).min().getAsInt();
		int maxY = image.stream().mapToInt(p -> p.getY()).max().getAsInt();

		for (int y = minY; y < maxY; y++) {
			for (int x = minX; x < maxX; x++) {
				char characterAt = getCharacterAt(image, x, y, 1);
				System.out.print(characterAt == '1' ? '#' : '.');
			}
			System.out.println();
		}
		System.out.println();
	}

	public static int getIndex(List<Pixel> image, int x, int y, int step) {
		StringBuilder builder = new StringBuilder();
		builder.append(getCharacterAt(image, x - 1, y - 1, step));
		builder.append(getCharacterAt(image, x, y - 1, step));
		builder.append(getCharacterAt(image, x + 1, y - 1, step));
		builder.append(getCharacterAt(image, x - 1, y, step));
		builder.append(getCharacterAt(image, x, y, step));
		builder.append(getCharacterAt(image, x + 1, y, step));
		builder.append(getCharacterAt(image, x - 1, y + 1, step));
		builder.append(getCharacterAt(image, x, y + 1, step));
		builder.append(getCharacterAt(image, x + 1, y + 1, step));
		return Integer.parseInt(builder.toString(), 2);

	}

	public static char getCharacterAt(List<Pixel> image, int x, int y, int step) {
		Optional<Pixel> any = image.stream().filter(p -> p.atPosition(x, y)).findAny();
		return any.map(Pixel::getCharacter).orElse(step % 2 == 0 ? '0' : '1');
	}

}
