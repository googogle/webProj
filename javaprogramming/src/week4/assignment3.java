package week4;

import java.util.ArrayList;
import java.util.Scanner;

public class assignment3 {

	public static void main(String[] arg) {
		PhoneBook phonebook = new PhoneBook();
		phonebook.run();
	}
}

class Phone {
	public String name;
	public String pnum;

}

class PhoneBook {

	PhoneBook() {
	}

	void run() {
		Scanner scanner = new Scanner(System.in);
		int n;
		while (true) {
			n = scanner.nextInt();
			if (n > 0)
				break;
		}

		String name;
		String pnum;
		Phone[] list = new Phone[n];
		int t = 0;
		while (t < n) {
			name = scanner.next();
			pnum = scanner.next();
			Phone tmp = new Phone();
			tmp.name = name;
			tmp.pnum = pnum;
			list[t] = tmp;
			scanner.nextLine();
			t++;
		}
		System.out.println("저장되었습니다...");
	
		String searchName = " ";
		Boolean isMatched = false;
		while (true) {
			isMatched = false;
			searchName = scanner.next();
			// System.out.println("searchName = " + searchName);
			if (searchName.equals("그만"))
				return;
			for (int i = 0; i < n; i++) {
				// System.out.println("list.name = " + list.get(i).name);
				if (list[i].name.equals(searchName)) {
					System.out.println(list[i].name + "의 번호는 " + list[i].pnum + " 입니다.");
					isMatched = true;
				}
			}
			if (!isMatched)
				System.out.println(searchName + " 이 없습니다.");
		}
	}
}
