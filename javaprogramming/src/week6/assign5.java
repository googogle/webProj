package week6;
import java.util.Scanner;
public class assign5 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuffer sb = new StringBuffer();
		sb.append(scanner.nextLine());

		while(true) {
			System.out.print("명령: ");
			String line2 = scanner.nextLine();
			if(line2.equals("그만")) { System.out.println("종료합니다."); return;}
			String[] cm = line2.split("!");
			if(sb.indexOf(cm[0]) == -1) System.out.println("찾을 수 없습니다!");
			else if(cm.length != 2)
				System.out.println("잘못된 명령입니다!");
			else {
				sb.replace(sb.indexOf(cm[0]), sb.indexOf(cm[0]) + cm[0].length(), cm[1]);
				System.out.println(sb);
			}
			
		}
		

	}

}
