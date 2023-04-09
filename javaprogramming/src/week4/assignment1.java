package week4;

public class assignment1 {

	public static void main(String[] args) {
			TV myTV = new TV("LG", 2017, 32);
			myTV.show();
	}

}

class TV {
	private String man;
	private int year;
	private int size;
	
	public TV(String m , int y, int s) {
		this.man = m;
		this.year = y;
		this.size = s;
	}
	
	public void show() {
		System.out.println(man+"에서 만든 "+ year+"년형 "+size+"인치 TV");
	}
}
