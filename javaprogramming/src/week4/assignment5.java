package week4;
import java.util.Scanner;

public class assignment5 {
	public static void main(String[] arg) {
		Scanner scanner = new Scanner(System.in);
		int x = 0;
		int y = 0;
		x = scanner.nextInt();
		y = scanner.nextInt();
		String op = scanner.next();
		if (op.equals("+")) {
			Add add = new Add();
			add.setValue(x, y);
			System.out.println(add.calculate());
			return;
		}
		if (op.equals("-")) {
			Sub sub = new Sub();
			sub.setValue(x, y);
			System.out.println(sub.calculate());
			return;
		}
		if (op.equals("*")) {
			Mul mul = new Mul();
			mul.setValue(x, y);
			System.out.println(mul.calculate());
			return;
		}
		if (op.equals("/")) {
			if(y == 0) {
				System.out.println("0으로 나눌 수 없습니다.");
				return;
			}
			Div div = new Div();
			div.setValue(x, y);
			System.out.println(div.calculate());
			return;
		}
		else System.out.println("해당하는 연산이 없습니다.");
	}
}

class Add {
	int a, b;

	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int calculate() {
		return a + b;
	}
}

class Sub {
	int a, b;

	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int calculate() {
		return a - b;
	}
}

class Mul {
	int a, b;

	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int calculate() {
		return a * b;
	}
}

class Div {
	int a, b;

	void setValue(int a, int b) {
		this.a = a;
		this.b = b;
	}

	int calculate() {
		return a / b;
	}
}
