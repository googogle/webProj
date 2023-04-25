package week7;
import java.util.*;
public class assign4 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Vector<Shape> shapes = new Vector<Shape>();
		while(true) {
			System.out.print("삽입(1), 삭제(2), 모두 보기(3), 종료(4)>>");
			int n = scanner.nextInt();
			if(n == 4) { System.out.println("프로그램종료"); return; }
			else if(n == 1) {
				System.out.print("Line(1), Rect(2), Circle(3)>>");
				int n2 = scanner.nextInt();
				if(n2 == 1) shapes.add(new Line());
				else if(n2 == 2) shapes.add(new Rect());
				else if(n2 == 3) shapes.add(new Circle());
			}
			else if(n == 3) {
				for(Shape s : shapes) s.draw();
			}
			else if(n == 2) {
				System.out.print("삭제할 도형의 위치>>");
				int n3 = scanner.nextInt();
				if(shapes.size() < n3 ) {
					if(shapes.get(n3-1) == null)
					System.out.println("삭제할 수 없습니다.");
				}
				else { shapes.remove(n3-1) ;}
			}
		}

	}

}

abstract class Shape {
	public Shape() {};
	abstract public void draw();
}

class Line extends Shape{
	public void draw() { System.out.println("Line"); }

}

class Rect extends Shape{
	public void draw() { System.out.println("Rect"); }

}

class Circle extends Shape{
	public void draw() { System.out.println("Circle"); }

}


