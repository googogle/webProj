package javaprogramming.week3;

import java.util.Scanner;

public class assignment2 {

	public static void main(String[] args) {
		int n = 0;
		Scanner scanner = new Scanner(System.in);
		while (true) {
			n = scanner.nextInt();
			if (n > 0 && n < 19)
				break;
			else
				System.out.println(-1);
		}
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j < (n - i); j++)
				System.out.print("*");
			System.out.println();
		}
	}
}
