package be.ccfun.aoc.day16;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day16 {
	private static List<String> lines = null;
	private static int totalVersion = 0;

	public static void main(String[] arg) throws IOException {
		lines = Files.readAllLines(Path.of("src/main/resources/day16.txt"));
		String hexAddr = lines.get(0);
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < hexAddr.length(); i++) {
			String s = Integer.toBinaryString(Integer.parseInt(hexAddr.substring(i, i + 1), 16));
			builder.append(("0000" + s).substring(s.length()));
			System.out.println(builder.toString());
		}
		String binary = builder.toString();
		parsePacket(binary);

	}

	private static int parsePacket(String binary) {
		int version = Integer.parseInt(binary.substring(0, 3), 2); // 3-bits
		System.out.println("Version: " + version);
		totalVersion += version;
		System.out.println(totalVersion);
		int type = Integer.parseInt(binary.substring(3, 6), 2); // 3-bits
		System.out.println("Type: " + type); // other than 4 is operator
		if (type != 4) {
			int lengthType = Integer.parseInt(binary.substring(6, 7), 2); // 1-bits
			System.out.println("LengthType: " + lengthType);
			int bits = 15;
			if (lengthType == 1) {
				bits = 11;
			}
			if (bits == 15) {
				int subpackets = Integer.parseInt(binary.substring(7, 7 + bits), 2); // 11-bits
				System.out.println("Subpackets: " + subpackets);
				int subpacketStart = 7 + bits;
				int bitsRead = 0;
				while (bitsRead < subpackets) {
					int endOfPacket = parsePacket(binary.substring(subpacketStart));
					subpacketStart += endOfPacket;
					bitsRead += endOfPacket;
				}
				return subpacketStart;
			} else {
				int subpackets = Integer.parseInt(binary.substring(7, 7 + bits), 2); // 11-bits
				System.out.println("Subpackets: " + subpackets);
				int subpacketStart = 7 + bits;
				for (int i = 0; i < subpackets; i++)  {
					int endOfPacket = parsePacket(binary.substring(subpacketStart));
					subpacketStart += endOfPacket;
				}
				return subpacketStart;
			}
		} else {
			boolean reading = true;
			int index = 6;
			StringBuilder builder = new StringBuilder();
			while (reading) {
				builder.append(binary.substring(index + 1, index + 5));
				reading = binary.charAt(index) == '1';
				index += 5;
			}
			System.out.println("Literal: " + Long.parseLong(builder.toString(), 2));
			return index;
		}
	}
}
