package week5;
import java.util.Scanner;
public class assign4 {

	public static void main(String[] args) {
		StackApp.run();

	}
}

interface Stack {
	  int length(); // 현재 스택에 저장된 개수 리턴
	  int capacity(); // 스택의 전체 저장 가능한 개수 리턴
	  String pop(); // 스택의 톱(top)에 저장된 실수 리턴
	  boolean push(String val); // 스택의 톱(top)에 실수 저장
	}
	class StringStack implements Stack {
		public StringStack(int cap){this.capacity = cap; strings = new String[cap];};
		private String[] strings;
		private int top = 0;
		private int length = 0;
		public int length() {return this.length;}
		private int capacity = 0;
		public int capacity() {return this.capacity;}
		public int getTop() {return this.top;}
		public String pop() {if (top > 0 )return strings[--top]; else return null;}
		public boolean push(String val) {
			if(top == capacity) return false;
			else {strings[top++] = val; return true;}
		}
		
	}
	class StackApp {
	  public static void run() {
		  Scanner scanner = new Scanner(System.in);
		  int n = scanner.nextInt();
		  StringStack ss = new StringStack(n);
		  while(true) {
			  String str = scanner.next();
			  if(str.equals("그만")) break;
			  if(!ss.push(str)) System.out.println("스택이 꽉 차서 푸시 불가!");
		  }
		  System.out.print("스택에 저장된 모든 문자열 팝 : ");
		  for(int i = 0 ; i < n ; i ++) System.out.print(ss.pop() + " ");
	  }
	}
