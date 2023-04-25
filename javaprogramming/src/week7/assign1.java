package week7;

import java.util.Scanner;
import java.util.Vector;

public class assign1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Integer> v = new Vector<Integer>();
		System.out.print("정수(-1이 입력될 때가지)>> ");
		int n = 0;
		int max = 0;
		while (true) {

			n = scanner.nextInt();
			v.add(n);
			if (n == -1)
				break;
		}
		max = v.get(0);
        for(int num : v) {
            if(max < num) max = num;
        }
		System.out.println("가장 큰 수는 " + max);

	}
}
