package week6;

import java.util.Scanner;
import java.util.StringTokenizer;

public class assign2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String line;
		while (true) {
			line = scanner.nextLine();
			if (line.equals("그만")) {
				System.out.println("종료합니다...");
				break;
			}

			StringTokenizer st = new StringTokenizer(line);
			int count = st.countTokens();
			System.out.println("어절 개수는 " + count);
		}
	}

}
