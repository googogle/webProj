package javaprogramming.week3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class assignment6 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				int n = scanner.nextInt();
				int m = scanner.nextInt();
				System.out.println(n * m);
				break;
			} catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println(-1);
			}
		}
	}
}
