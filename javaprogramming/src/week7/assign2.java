package week7;

import java.util.Scanner;
import java.util.Vector;

public class assign2 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		int avg;
		int sum;
		while (true) {
			sum = 0;
			avg = 0;
			System.out.print("강수량 입력 (0 입력시 종료)>> ");
			int n = scanner.nextInt();
			if (n == 0)
				return;
			v.add(n);
			for (int num : v) {
				sum += num;
			}
			print(v);
			System.out.println();
			avg = sum / v.size();
			System.out.println("현재 평균 " + avg);
		}

	}

	public static void print(Vector<Integer> v) {
		for (int num : v)
			System.out.print(num + " ");

	}

}
