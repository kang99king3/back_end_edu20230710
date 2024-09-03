package hk.edu20230803.day09_2;

import java.util.Arrays;
import java.util.Scanner;

public class Hitter {
	
	public int []batBall;
	
	public Hitter() {
		batBall=new int [3];
	}
	
	//타자로부터 숫자 3개를 입력받게 하고 batBall배열에 저장한다.
	public int[] make(){
		Scanner scan=new Scanner(System.in);
		while(true){
			System.out.print("숫자입력: ");
			char []c=scan.next().toCharArray();
			if(c.length==3&&!inputIsSame(c)){
				for (int i = 0; i < batBall.length; i++) {
					batBall[i]=c[i]-'0';//int형변환
				}
				break;
			}else{
				System.out.println("숫자 3개만 입력해야하며 중복된 숫자를 입력할 수 없습니다.");
			}
		}
		
		return batBall;
	}
	
	//타자가 중복되는 숫자를 입력하는 경우를 체크
	public boolean inputIsSame(char[] c) {
		boolean isS=false;
		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c.length; j++) {
				if(c[i]==c[j]&&i!=j) {
					isS=true;
				}
			}
		}
		return isS;
	}
	
	public void Bprint(){
			System.out.println("\n"+Arrays.toString(batBall));
	}
}
