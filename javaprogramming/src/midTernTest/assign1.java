package midTernTest;

import java.util.Scanner;

public class assign1 {

	public static void main(String[] args) {
			prob0 a = new prob0();
			a.doTask();
	}

}

/*class prob0{
	public void doTask() {
		Scanner sc = new Scanner(System.in);
		int i = sc.nextInt();
		int j = 0;
		
		if(i == 10) j+=5;
		else if (i ==20) j+=120;
		else j+=100;
		
		System.out.println(j);
		
	}
}*/

class prob0 {
    public void doTask(){
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        int j = 0;

        switch (i) {
            case 10:
                j+=5;
                break;
            case 20:
                j+=10;
            default:
                j+=100;
        }

        System.out.println(j);
    }
}
