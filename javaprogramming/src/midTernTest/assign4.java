package midTernTest;

import java.util.Scanner;

public class assign4 {

	public static void main(String[] args) {
		String regExp = "^[1-9]$";
		Scanner sc = new Scanner(System.in);
		int n = 0;
		while (true) {
			String s = sc.next();
			if (s.matches(regExp)) {
				n = Integer.parseInt(s);
				break;
			}
		}
		try {}
		catch (Exception e){
			
		}
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - (i + 1); j++) {
				System.out.print("  ");
			}
			for (int k = 1; k <= ((i+1)*2)-1; k++) {
				System.out.print( Math.abs((i+1) - k) +1+ " ");
			}
			System.out.println();
		}

	}

}
