package week6;

public class assign1 {

	public static void main(String[] args) {
	    Circle a = new Circle(2, 3, 5);
	    Circle b = new Circle(2, 3, 20);
	    System.out.println("원 a : " + a);
	    System.out.println("원 b : " + b);
	    if(a.equals(b)) System.out.println("같은 원");
	    else System.out.println("서로 다른 원");

	}

}

class Circle {
	private int x;
	private int y;
	private int radious;
	public int getX() {return x;}
	public int getY() {return y;}
	public int getRadious() {return radious;}
	
	public Circle(int x, int y, int r) {this.x = x; this.y = y ; this.radious = r;}
	public boolean equals(Circle c) {
		if(this.x == c.getX() && this.y == c.getY()) return true;
		else return false;
	}
    @Override
    public String toString() {
        return "Circle(" + x + "," + y + ")반지름" + getRadious();
    }
}
