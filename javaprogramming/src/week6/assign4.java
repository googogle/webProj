package week6;

import java.util.Scanner;

public class assign4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();

		int len = str.length();
		for (int i = 1; i < len+1; i++) {
			String rotated = str.substring(i) + str.substring(0, i);
			System.out.println(rotated);
		}
	}

}
