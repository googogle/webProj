package midTernTest;

import java.util.Scanner;
import java.util.Vector;

public class assign6 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n ;
		int aa = 0;
		int a = 0;
		int i = 0;
		n = sc.nextInt();
		int arr[] = new int[26];
		for(int k = 0 ; k < 26 ; k ++) arr[k] = 0;
		while(i<n ) {
			String s = sc.next();
			if(s.length() == 1) {
				int nn = (int)s.charAt(0);
				if((nn>=65 && nn<=90)) {
					arr[nn-65] += 1; 
					}
				if((nn>=97 && nn<=122)) {
				arr[nn-97] += 1; 
				}
			}
			i ++;
			/*if(s.length() == 1 && ((int)s.charAt(0)>=65 && (int)s.charAt(0)<=90)) { aa+=1 ; i ++; } 
			if(s.length() == 1 && ((int)s.charAt(0)>=97 && (int)s.charAt(0)<=122)) { a+=1 ; i ++; } */
		}
		for(int j = 0 ; j < 26 ; j ++) {
			if(arr[j] != 0) {
				System.out.println((char)(j+97)+":"+arr[j]);
			}
		}

	}

}
