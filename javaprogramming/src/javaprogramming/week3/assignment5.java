package javaprogramming.week3;

import java.util.Scanner;

public class assignment5 {

	public static void main(String[] args) {
		boolean hitflag = false;
		String course[] = { "Java", "C++", "HTML5", "ComputerStructure", "Android" };
		int score[] = { 95, 88, 76, 62, 55 };
		Scanner scanner = new Scanner(System.in);
		String s = " ";
		while (true) {
			hitflag = false;
			s = scanner.next();
			if (s.equals("-1"))
				break;
			for (int i = 0; i < 5; i++) {
				if (course[i].equals(s)) {
					System.out.println(course[i] + " : " + score[i]);
					hitflag = true;
					break;
				}
			}
			if(!hitflag)System.out.println("N/A");
		}
	}

}
