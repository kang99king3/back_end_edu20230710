package hk.edu20230727.day04;

public class Divisor {

	public int num;
	
	public Divisor() {
		// TODO Auto-generated constructor stub
	}
	
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
		System.out.println("========================");
		//                            |    284      |    
//		System.out.println(220==sumDivisor(sumDivisor(220)));  
		amicable(1, 5000);
		System.out.println("========================");
		perfectNum(1, 10000);
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
	
	//최소공배수
//	10 20  --> (10*20)/(두수의 최대공약수)
	public static void lowestMultiple(int a, int b) {
		int val=greateDivisor(a, b);
		System.out.println(a+"와"+b+"의 최소공배수는:"+(a*b)/val);
//		(tempA*tempB)/a;
	}
	
	//친화수구하기
	// 220의 진약수합 ---> 284의 진약수의 합--->220
	// 범위를 지정해서 친화수를 찾는 메서드,  1 ~1000 까지 입력받기
	public static void amicable(int start, int end) {
		for (int i = start; i < end; i++) {
			if(i!=sumDivisor(i)&&i==sumDivisor(sumDivisor(i))) {
				System.out.println(i+":"+sumDivisor(i)+" 는 친화수 관계이다.");
			}
		}
	}
	
	//진약수의 합을 구하는 메서드 
	public static int sumDivisor(int a) {
//		int a=220;
		int sum=0;//합을 저장할 변수 선언
		for (int i = 1; i < a; i++) {
			if(a%i==0) { //약수냐??
				sum+=i;//단축연산자:  sum=sum+i;
			}
		}
		return sum; // 외부에서 호출했을때 값을 전달할 수 있다
	}
	
	//완전수를 구하는 메서드: 진약수의 합을 구하는 메서드 활용
	public static void perfectNum(int start, int end) {
		for (int i = start; i < end; i++) {
			if(sumDivisor(i)==i) {
				System.out.printf("%d은 완전수이다\n",i);
			}
		}
	}
	
	
}













