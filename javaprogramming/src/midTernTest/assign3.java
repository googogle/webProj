package midTernTest;

import java.util.Scanner;

public class assign3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n ;
		int aa = 0;
		int a = 0;
		int i = 0;
		n = sc.nextInt();
		while(i<n ) {
			String s = sc.next();
			if(s.length() == 1) {
				int nn = (int)s.charAt(0);
				if(nn>=65 && nn<=90) { aa+=1 ;  }
				if(nn>=97 && nn<=122){ a+=1 ;  }
			}
			i ++ ;
			/*if(s.length() == 1 && ((int)s.charAt(0)>=65 && (int)s.charAt(0)<=90)) { aa+=1 ; i ++; } 
			if(s.length() == 1 && ((int)s.charAt(0)>=97 && (int)s.charAt(0)<=122)) { a+=1 ; i ++; } */
		}
		System.out.println(a);
		System.out.println(aa);

	}

}
