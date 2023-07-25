package hk.edu20230725.day02;

public class ControlFlow {

	public static void main(String[] args) {
		
		//if문
		//유형 3가지+1
		//1. if(조건식){실행코드}
		//2. if(조건식){실행코드}else{실행코드}
		//3. if(조건식){실행코드}else if(조건식){실행코드}else if(조건....
		//4. if(조건식){실행코드} if(조건식){실행코드} if(조건식){실행코드}
		
		int num1=10;
		int num2=5;
		
		//if문을 독립적으로 사용: if문끼리 영향이 없음
		if(num1>num2) {
			System.out.println("실행결과:"+num1+">"+num2);
		}
		
		if(num1<num2) {
			System.out.println("실행결과:"+num1+"<"+num2);
		}
		
		//참과 거짓에 의한 실행이 반드시 일어나야 하는경우
		if(num1>num2) {
			System.out.println("실행결과:"+num1+">"+num2);
		}else {
			System.out.println("실행결과:"+num1+"<"+num2);
		}
		
		//여러 조건을 설정해서 실행할 경우
		if(num1>num2) {
			if(num1!=num2) { 
				//if문을 중첩해서 사용
			}
		}else if(num1<num2) {
			
		}else if(num1==num2) {
			
		}else {
			
		}
		
		//switch case문
		int num=10;
		switch (num) {
			case 1:  System.out.println("1입니다");break;
			case 5:  System.out.println("5입니다");break;
			case 10: System.out.println("10입니다");break;
			case 15: System.out.println("15입니다");break;
			case 20: System.out.println("20입니다");break;
			default: System.out.println("일치하는 값이 없어요");
				break;
		}
	}
}





