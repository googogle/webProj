package week4;

import java.util.Scanner;

public class assignment4 {
	public static void main(String[] arg) {
		DicApp dicApp = new DicApp();
		dicApp.run();
		return ;
	}
}

class Dictionary {
	private static String[] kor = { "사랑", "아기", "돈", "미래", "희망" };
	private static String[] eng = { "love", "baby", "money", "future", "hope" };

	public static String kor2Eng(String word) {
		String result = "noResult";
		for(int i = 0 ; i < kor.length ; i ++) {
			if(word.equals(kor[i])) result = eng[i]; 
		}
		return result;
	}
}

class DicApp {
	
	public DicApp() {};
	
	public void run() {
		System.out.println("한영 단어 검색 프로그램입니다.");
		String kor;
		String eng;
		
		while(true) {
			Scanner scanner = new Scanner(System.in);
			kor = scanner.next();
			if(kor.equals("그만")) break;
			
			eng = Dictionary.kor2Eng(kor);
			if(eng.equals("noResult")) System.out.println(kor + " : 저의 사전에 없습니다.");
			else System.out.println(kor + " : " + eng);
			
		}
	}
}
