package hk.edu20230726.day03;

public class D2_Gugudan {

	public static void main(String[] args) {
		
		D1_ControlFlow_For_While d=new D1_ControlFlow_For_While();
		
		//구구단 출력하기
		//2단 출력: 2X1=2, 2X2=4..... 범위는 1~9 까지 곱하기
		for (int i = 1; i <= 9; i++) {
			System.out.println("2X"+i+"="+(2*i));
		}
		
		//2~9단 출력하기
		for (int i = 2; i <= 9; i++) {
			//하나의 단을 구하는 for문
			for (int j = 1; j<= 9; j++) {
				System.out.println(i+"X"+j+"="+(i*j));
			}
			System.out.println();// ()작성하면 그냥 줄바꿈한번
		}
		
		//1. 2~9단까지 출력하는데 이때 짝수단만 출력하기
		for (int i = 2; i <= 9; i++) {
			if(i%2==0) {
				//하나의 단을 구하는 for문
				for (int j = 1; j<= 9; j++) {
					System.out.println(i+"X"+j+"="+(i*j));
				}				
			}
			System.out.println();// ()작성하면 그냥 줄바꿈한번
		}
		System.out.println("=======================");
		//2. 2~9단까지 출력하는데 이때 홀수단만 출력하기
		for (int i = 2; i <= 9; i++) {
			if(i%2!=0) {
				//하나의 단을 구하는 for문
				for (int j = 1; j<= 9; j++) {
					System.out.println(i+"X"+j+"="+(i*j));
				}				
			}
			System.out.println();// ()작성하면 그냥 줄바꿈한번
		}
		
		//3. 1~100까지의 정수의 총 합을 출력하자
		// 1 2 3 4 5 6 7 8 .. 100
		// 1+2+3+4... 
		// 1+2
		//   3+3
		int sum=0;//정수들의 합을 저장할 변수
		for (int j = 1; j <= 100; j++) {
//			sum=sum+j;		
			sum+=j;//단축연산자 사용
		}
		System.out.println("1~100까지의 총합은?"+sum);
		
		//4. 1~100까지의 정수 중 3의 배수의 총합을 출력하자
		
		int sum1=0;//정수들의 합을 저장할 변수
		for (int j = 1; j <= 100; j++) {
			if(j%3==0) {
//				sum=sum+j;		
				sum1+=j;//단축연산자 사용				
			}
		}
		System.out.println("1~100중에 3의배수의 총합은?"+sum1);
		
		//5. 주사위의 합이 5이면 실행을 멈추고, 5가 아니면 계속 실행하는 코드를 작성하자
		//실행 결과 출력하기 : (2,5) (1,3) (4,3) (2,3) 
		// 1~6까지의 숫자가 랜덤하게 생성이 되야 함
		//Math.random();// 0.00000.....1 ~ 0.9999999999 : 0~1사이의 실수를 랜덤하게 반환함
		System.out.println(Math.random());
		int number=(int)(Math.random()*6+1);//  0~1 --> *6 --> 0.0000006 ~ 5.9999999 -> 0~5
		System.out.println(number);
		
		while(true) {
			int number1=(int)(Math.random()*6+1);//주사위1
			int number2=(int)(Math.random()*6+1);//주사위2
//			System.out.println("("+number1+","+number2+")");
			System.out.printf("(%d,%d)\n",number1,number2);
			
			if(number1+number2==5) { //while문을 종료하는 코드
				System.out.println("합이 5가 되어 종료합니다.");
				break;
			}
		}
	}
}












