package javaprogramming.week3;

import java.util.Scanner;

public class assignment3 {

	public static void main(String[] args) {
		char c = 0;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			c = scanner.next().charAt(0);
			if ((int) c < 97 || (int) c > 122)
				System.out.println(-1);
			else
				break;
		}
		for (int i = 0; i <= (int) c - 97; i++) {
			for (int j = 97; j <= (int) c - i; j++)
				System.out.print((char) j);
			System.out.println();
		}
	}
}
