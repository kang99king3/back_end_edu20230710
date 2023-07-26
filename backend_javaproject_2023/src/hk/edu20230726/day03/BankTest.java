package hk.edu20230726.day03;

import java.util.Scanner;

public class BankTest {

	public static void main(String[] args) {
		//참조타입  객체명
//		 Scanner  scan = new Scanner(System.in);
//		 String s = scan.next();
//		 System.out.println("출력하기:"+s);
//		 s = scan.next();
//		 System.out.println("출력하기:"+s);
		 
		//while문과 Scanner를 이용해서 키보드로부터 입력된 데이터로 예금, 출금, 조회, 종료 기능을 
		//제공하는 코드를 작성해보세요. 이 프로그램을 실행시키면 다음과 같은 실행 결과가 나와야 합니다.
		//추가 문제: 출금을 할때 잔액이 초과되면 초과됐다고 안내하고 다시 입력받게 하자 
		
		Scanner scan=new Scanner(System.in);
		
		int balance=0;//계좌
		
		while(true) {
			System.out.println("--------------------------");
			System.out.println("1.예금|2.출금|3.잔고|4.종료");
			System.out.println("--------------------------");
			System.out.println("선택>");
			
			int num=scan.nextInt();
			
			if(num==4) {
				break;
			}
			
			//1~4번외에 번호를 입력하면 다시 입력하라고 알려주고 다시 입력받기
			
		}
	}
}










