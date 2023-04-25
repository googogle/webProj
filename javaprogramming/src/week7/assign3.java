package week7;

import java.util.*;

public class assign3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		HashMap<String, Integer> customers = new HashMap<>();
		String name;
		int point;

		while (true) {
			boolean flag = true;
			name = scanner.next();
			if (name.equals("그만"))
				return;
			point = scanner.nextInt();

			if (customers.get(name) == null)
				customers.put(name, point);

			else {
				int newPoint = customers.get(name) + point;

				customers.put(name, newPoint);
			}

			for (Map.Entry<String, Integer> entry : customers.entrySet()) {
				String n = entry.getKey();
				int p = entry.getValue();
				System.out.print("(" + n + ", " + p + ")");
			}
			System.out.println();
		}
	}

}

class CustomerManager {
	public HashMap<String, Object> customer;

}