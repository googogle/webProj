package javaprogramming.week3;
import java.util.Scanner;

public class assignment4 {

	public static void main(String[] args) {
		
		String s = "66";
		int jjakFlag = 0;
		for(int i = 0 ; i<= 99 ; i ++) {
			jjakFlag = 0;
			s = Integer.toString(i);
			for(int k = 0 ; k < s.length() ; k ++) {
				if(s.charAt(k) == '3' || s.charAt(k) == '6' || s.charAt(k) == '9' )
					jjakFlag +=1;
			}
			if(jjakFlag != 0) {
				System.out.print(i+" ");
				for(int j = 0 ; j < jjakFlag ; j++) 
					System.out.print("jjak");
				System.out.println();
			}
				
		}
	}

}
