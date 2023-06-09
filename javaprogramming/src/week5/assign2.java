package week5;

import java.util.Scanner;

public class assign2 {

	public static void main(String[] args) {
		Km2Mile toMile = new Km2Mile(1.6);
		toMile.run();

	}

}

abstract class Converter {
	abstract protected double convert(double src);
	
	public Converter() {}

	abstract protected String getDestString();

	protected double ratio;

	public void run() {
		Scanner scanner = new Scanner(System.in);
		double val = scanner.nextDouble();
		double res = convert(val);
		System.out.println("변환 결과: " + res + getDestString() + "입니다.");
		scanner.close();
	}
}

class Km2Mile extends Converter{
	protected double convert(double src) {return src/ratio;};
	private String destString = "Mile";
	public Km2Mile(double r) {this.ratio = r;}
	protected String getDestString() {
		return destString;
	}
}