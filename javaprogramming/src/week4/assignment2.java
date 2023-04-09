package week4;
import java.util.Scanner;

public class assignment2 {

	public static void main(String[] args) {
	    int x, y, w, h;
	    Scanner scanner = new Scanner(System.in);
	    Rectangle t = new Rectangle(1, 1, 10, 10);
	    x = scanner.nextInt();
	    y = scanner.nextInt();
	    w = scanner.nextInt();
	    h = scanner.nextInt();
	    Rectangle r = new Rectangle(x, y, w, h);
	    x = scanner.nextInt();
	    y = scanner.nextInt();
	    w = scanner.nextInt();
	    h = scanner.nextInt();
	    Rectangle s = new Rectangle(x, y, w, h);
	    r.show();
	    System.out.println("s의 면적은 " + s.square());
	    if(t.contains(r)) System.out.println("t는 r을 포함합니다.");
	    if(t.contains(s)) System.out.println("t는 s를 포함합니다.");

	}
}

class Rectangle{
	private int x;
	private int y;
	private int w;
	private int h;
	
	public Rectangle(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	int square() {
		return w * h;
	}
	
	void show() {
		System.out.println("("+x + ","+y+")에서 크기가 "+ w + "x"+ h + "인 사각형");
	}
	
	Boolean contains(Rectangle r) {
		if(r.x + r.w > 10 || r.x > 10 || r.w > 10) return false;
		if(r.y + r.h > 10 || r.y > 10 || r.h > 10) return false;
		if(r.x + r.w < 1 || r.x < 1 || r.w < 1) return false;
		if(r.y + r.h < 1 || r.y < 1 || r.h < 1) return false;
		
		return true;
	}
}
