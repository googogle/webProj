package week6;

import java.util.Scanner;

public class assign3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line;

		while (true) {
			line = scanner.nextLine();
			if (line.equals("그만")) {
				System.out.println("종료합니다...");
				break;
			}

			String[] words = line.split(" ");
			int count = words.length;
			System.out.println("어절 개수는 " + count);
		}
	}

}
