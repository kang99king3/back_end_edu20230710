package hk.edu20230727.day04;

public class Divisor {

	public static void main(String[] args) {
		
		//12약수 : 1~12까지의 수로 12를 나누는 작업
//		for (int i = 1; i <= 12; i++) {
//			if(12%i==0) {
//				System.out.print((i==12)?i:i+",");
//			}
//		}
		
		divisor(6);
		System.out.println("========================");
		greateDivisor(30, 20);
		System.out.println("========================");
		lowestMultiple(10, 20);
	}
	
	//약수를 구하는 메서드
	public static void divisor(int num) {
		for (int i = 1; i <= num; i++) {
			if(num%i==0) {
				System.out.print((i==num)?i:i+",");
			}
		}
	}
	
	//최대공약수구하기
	public static int greateDivisor(int a, int b) {
		int tempA=a;//기본타입의 특징: 값을 복사해서 전달
		int tempB=b;
		
		while(true) {
			//a가 b보다 클 경우
			if(a>b) {
				a=a-b;
			}
			//b가 a보다 클 경우
			if(b>a) {
				b=b-a;
			}
			//a와 b가 같은 경우
			if(a==b) {
				break;
			}
		}
		
		System.out.println(tempA+"와"+tempB+"의 최대공약수는 "+a);
		return a;
	}
	
//	10 20  --> (10*20)/(두수의 최대공약수)
	public static void lowestMultiple(int a, int b) {
		int val=greateDivisor(a, b);
		System.out.println(a+"와"+b+"의 최소공배수는:"+(a*b)/val);
//		(tempA*tempB)/a;
	}
}








